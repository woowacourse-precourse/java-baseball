package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.Scanner;
import java.util.Random;

public class Application {

    static void print_result(int ball, int strike) {
        if (ball != 0) System.out.print(ball + "볼 ");
        if (strike != 0) System.out.println(strike + "스트라이크");
    }

    static int count_strike(int user_number, int computer_number) {
        int ball = 0;
        int strike = 0;
        String user_str = user_number + "";
        String computer_str = computer_number + "";
        for (int i = 0; i < 3; i++) {
            if (user_str.charAt(i) == computer_str.charAt(i)) strike += 1;
            else if (user_str.indexOf(computer_str.charAt(i)) != -1) ball += 1;
        }

        print_result(ball, strike);

        return strike;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner sc = new Scanner(System.in);
//        int computer_number = (int) ((Math.random() * (899)) + 100);
        int computer_number = Randoms.pickNumberInRange(100, 1000);

        System.out.println("숫자 야구 게임을 시작합니다.");
        int strike = 0;
        int input_number;
        while (strike != 3) {
            System.out.print("숫자를 입력해주세요: ");
            try {
                input_number = Integer.parseInt(Console.readLine());
                strike = count_strike(input_number, computer_number);
            } catch (IllegalArgumentException e) {
                break;
            }
        }

    }
}
