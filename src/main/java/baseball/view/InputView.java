package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String NUMBER_PATTERN = "^[0-9]*$";

    public static List<Integer> getBalls() {
        System.out.println("숫자를 입력해주세요 : ");
        int number = inputNumber();
        List<Integer> digits = new ArrayList<>();
        while (number > 0) {
            digits.add(number % 10);
            number /= 10;
        }
        return digits;
    }

    public static int restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int status = inputNumber();
        return status;
    }

    private static int inputNumber() {
        String input = Console.readLine();
        validateNumber(input);
        return Integer.parseInt(input);
    }

    private static void validateNumber(String input) {
        if (!input.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }
}
