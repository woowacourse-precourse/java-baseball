package baseball;
import java.util.Random;
import java.util.Scanner;
public class Application {
    public static void game(String str){
        int num = 0;
        int num2=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (str != Integer.toString(num)) {
            int strike = 0;
            int ball = 0;

            System.out.print("숫자를 입력해주세요 : ");
            num = sc.nextInt();
            if (Integer.parseInt(str) == num) {
                break;
            }
            String num_str = Integer.toString(num);

            for (int i = 0; i < 3; i++) {
                if (num_str.charAt(i) == str.charAt(i)) {
                    strike += 1;
                    continue;
                }
                if (str.contains(String.valueOf(num_str.charAt(i)))) {

                    ball += 1;
                }
            }
            if(ball==0 && strike==0){
                System.out.println("낫싱");
                continue;
            }
            String answer="";
            String ball2= (ball==0) ? "": ball+"볼"+" ";
            answer+=ball2;
            String strike2= (strike==0) ? "": strike+"스트라이크";
            answer+=strike2;
            System.out.println(answer);


        }


    }
    public static void main(String[] args) {
        //컴퓨터 숫자 선언

        int value;
        int num2=1;
        String str = "";
        Random random = new Random();
        //서로 다른 수 세자리 만들기
        while (true) {
            if (str.length() == 3) {
                break;
            }
            value = random.nextInt(9) + 1;

            if (!str.contains(Integer.toString(value))) {

                str += value;

            }
        }


        Scanner sc = new Scanner(System.in);
        while(num2==1){
            game(str);
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            num2 = sc.nextInt();

        }




        }


    }


