package baseball;

//import java.util.Scanner;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //Scanner scan = new Scanner(System.in);


        int num = 0, game = 1, strike = 0, ball = 0, flag = 0, temp = 0;
        int[] computer = new int[3];
        int[] player = new int[3];
        int[] save = new int[3];


        System.out.println("숫자 야구 게임을 시작합니다.");

        while(game != 2) {
            if (temp == 0){
                //computer[0] = (int)(Math.random() * 9 + 1);
                //computer[1] = (int)(Math.random() * 9 + 1);
                //computer[2] = (int)(Math.random() * 9 + 1);
                computer[0] = Randoms.pickNumberInRange(1, 9);
                computer[1] = Randoms.pickNumberInRange(1, 9);
                computer[2] = Randoms.pickNumberInRange(1, 9);
            }
            else{
                computer[0] = save[0];
                computer[1] = save[1];
                computer[2] = save[2];
                temp = 0;
            }


            System.out.println("com" + computer[0] + " " + computer[1] + computer[2]);

            try {

                while(flag == 0){
                    System.out.print("숫자를 입력해주세요 : ");
                    //num = scan.nextInt();
                    num = Integer.parseInt(Console.readLine());

                    System.out.println(num);
                    System.out.println(Integer.toString(num).length());

                    if(Integer.toString(num).length() != 3) {
                        save[0] = computer[0];
                        save[1] = computer[1];
                        save[2] = computer[2];
                        temp = 1;
                        //break;
                        throw new IllegalArgumentException();
                        //continue;
                    }

                    player[0] = num / 100;
                    player[1] = num / 10 - num / 100 * 10;
                    player[2] = num % 10;

                    System.out.println(player[0] + " " + player[1] + player[2]);

                    if(computer[0] == player[0] && computer[1] == player[1] && computer[2] == player[2]){
                        System.out.println("3스트라이크");
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        flag = 1;
                        break;
                    }
                    else {
                        for(int i = 0; i < 3; i++){
                            if(computer[i] == player[i]){
                                strike++;
                            }
                            else {
                                for(int j = 0; j < 3; j++) {
                                    if (computer[i] == player[j]) {
                                        ball++;
                                        break;
                                    }
                                }
                            }

                        }

                        if(ball != 0 && strike == 0){
                            System.out.println(ball + "볼");
                            ball = 0;
                        }
                        else if(strike != 0 && ball == 0){
                            System.out.println(strike + "스트라이크");
                            strike = 0;
                        }
                        else if(strike != 0 && ball != 0){
                            System.out.println(ball + "볼 " + strike + "스트라이크");
                            ball = 0;
                            strike = 0;
                        }
                        else {
                            System.out.println("낫싱");
                        }

                    }
                }

                //if(temp == 1){
                    //break;
                //}

                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                //game = scan.nextInt();
                game = Integer.parseInt(Console.readLine());

                System.out.println(game);

                if(game != 1 && game != 2) {
                    throw new IllegalArgumentException();
                }
                else if(game == 1){
                    flag = 0;
                    continue;
                }
                else if (game == 2){
                    break;
                }


            }catch(IllegalArgumentException e) {
                System.out.println("IllegalArgumentException 발생!!");
                //break;
            }

        }

        System.out.println("게임 종료");

        //scan.close();
    }
}
