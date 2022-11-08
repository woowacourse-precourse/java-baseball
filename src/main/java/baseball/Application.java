package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

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
        input_number = Console.readLine();
        if (!check_legitimacy(input_number)) throw new IllegalArgumentException();

        return input_number;
    }

    static boolean get_continue_option() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int option = Integer.parseInt(Console.readLine());
        return (option != 1);
    }

    static boolean play_game(String computer_number) {
        int strike = 0;
        String input_number;
        while (strike != 3) {
            System.out.print("숫자를 입력해주세요: ");
            input_number = get_input();
            strike = count_strike(input_number, computer_number);
        }
        return get_continue_option();
    }

    static boolean check_legitimacy(String number) {
        char[] num_arr = number.toCharArray();
        boolean condition1 = num_arr[0] != num_arr[1];
        boolean condition2 = num_arr[0] != num_arr[2];
        boolean condition3 = num_arr[1] != num_arr[2];
        boolean condition4 = (num_arr[0] != '0');
        boolean condition5 = (number.length() == 3);

        return condition1 && condition2 && condition3 && condition4 && condition5;
    }

    static String get_computer_number() {
        String computer_number = "";
        do {
            for (int i = 0; i < 3; i++)
                computer_number += Randoms.pickNumberInRange(0, 9);
        } while (!check_legitimacy(computer_number));
        return computer_number;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String computer_number;
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean quit = false;
        while (!quit) {
            computer_number = get_computer_number();
            quit = play_game(computer_number);
        }
    }
}
