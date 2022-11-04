package baseball;


import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int[] randomNum = new int[3]; // 서로다른 3개 숫자
        Random rand = new Random();

        for(int count = 0; count < 3; count++){ // 랜덤 숫자 3개 뽑기
            randomNum[count] = rand.nextInt(9) + 1; // 1 ~9
            for(int curCount = 0; curCount < count; curCount++){
                if(randomNum[count] == randomNum[curCount]){ // 중복이면
                    count--; // 중복 아닌 수로 다시 찾기
                }
            }
            System.out.println("num: " + randomNum[count]);
        }


        while(!game(randomNum)){
            game(randomNum);
        }
    }

    public static boolean game(int[] randomNum){
        boolean result = false;

        Scanner sc = new Scanner(System.in);

        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");
        String userNum = sc.nextLine();

        System.out.println("userNum: " + userNum);

        String[] userNumArr = userNum.split("");

        int ball = 0;
        int strike = 0;
        int nothing = 0;
        for(int i = 0; i < randomNum.length; i++){
            System.out.println("num: " + userNumArr[i]);
            String userTarget = String.valueOf(randomNum[i]); // int -> string 형변환
            if(userNum.contains(userTarget)){
                for(int j = 0; j < userNumArr.length; j++){
                    if(userTarget.equals(userNumArr[j])){
                        if(i == j){
                            ball++;
                        }else{
                            strike++;
                        }
                    }
                }
                System.out.println(userTarget + "포함되어있음");
            }else{
                nothing++;
            }
        }

        if(ball == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            reStart(randomNum);
            result = true;
        }
        else if(nothing == 3) {
            System.out.println("낫싱");
        }else if(ball == 0 && strike != 0){
            System.out.println(strike + "스트라이크");
        }else if(ball != 0 && strike == 0){
            System.out.println(ball + "볼");
        }else{
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }

        return result;
    }

    public static void reStart(int[] randomNum){
        Scanner sc = new Scanner(System.in);
        int reStart = sc.nextInt();

        if(reStart == 1){
            System.out.println("게임 재시작");
            game(randomNum);
        }else if(reStart == 2){
            System.out.println("게임 종료");
        }else{
            System.out.println("1 또는 2로 입력해주세요.");
        }

        return;
    }

}
