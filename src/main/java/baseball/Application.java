package baseball;

import java.util.Scanner;
import java.util.Random;
public class Application {
    static int[] count_score(int user_number, int computer_number) {
        int[] ball_strike = {0, 0};
        String user_str = user_number + "";
        String computer_str = computer_number + "";
        for (int i = 0; i < 3; i++) {
            if(user_str.charAt(i) == computer_str.charAt(i))
                ball_strike[1] += 1;
            else
            if(user_str.indexOf(computer_str.charAt(i)) != -1)
                ball_strike[0] += 1;

        }
        return ball_strike;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        int computer_number = (int) ((Math.random() * (899)) + 100);

        System.out.println("숫자 야구 게임을 시작합니다.");
        int ball = 0;
        int strike = 0;
        int input_number;
        int[] count_result = {-1, -1};
        while (strike != 3){
            System.out.print("숫자를 입력해주세요: ");
            input_number = sc.nextInt();
            count_result = count_score(input_number, computer_number);
            ball = count_result[0];
            strike = count_result[1];
            System.out.println("ball = " + ball);
            System.out.println("strike = " + strike);
        }

    }
}
