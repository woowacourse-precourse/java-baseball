package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;
import java.util.Random;

public class Application {

    static void print_result(int ball, int strike) {
        if (ball != 0) System.out.print(ball + "볼 ");
        if (strike != 0) System.out.print(strike + "스트라이크");
        if ((ball == 0) && (strike == 0)) System.out.print("낫싱");
        System.out.println();
    }

    static int count_strike(String user_number, String computer_number) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            if (user_number.charAt(i) == computer_number.charAt(i)) strike += 1;
            else if (user_number.indexOf(computer_number.charAt(i)) != -1) ball += 1;
        }

        print_result(ball, strike);

        return strike;
    }

    static String get_input() {
        String input_number;
        try {
            input_number = Console.readLine();
            if ((input_number.charAt(0) == '0') || (input_number.length() != 3)) throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            return "";
        }

        return input_number;
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String computer_number = Randoms.pickNumberInRange(100, 1000) + "";

        System.out.println("숫자 야구 게임을 시작합니다.");
        int strike = 0;
        String input_number;
        while (strike != 3) {
            System.out.print("숫자를 입력해주세요: ");
            input_number = get_input();
            if (input_number.equals(""))
                break;
            strike = count_strike(input_number,computer_number);
        }
        System.out.println(strike);

    }
}
