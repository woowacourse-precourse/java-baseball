package baseball.utils;

import baseball.exception.errors.UserNumberException;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;


public class InputUtil {
    public static int[] getUserNumberInput() {
        int[] userNumber = new int[3];
        String input = Console.readLine();
        String[] beforeArray = input.split("");
        for (int i = 0; i < 3; i++) {
            userNumber[i] = stringToInteger(beforeArray[i]);
        }
        return userNumber;
    }

    private static int stringToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private static void exception(int input) {
        if (String.valueOf(input).length() != 3) {
            throw new IllegalArgumentException("입력된 숫자가 3자리가 아닙니다.");
        }
        if (String.valueOf(input).contains("0")) {
            throw new IllegalArgumentException("입력된 숫자가 1에서 9 사이 숫자가 아닙니다.");
        }
        if (checkDuplicate(input)) {
            throw new IllegalArgumentException("입력된 숫자가 중복되었습니다.");
        }
    }
    private static boolean checkDuplicate(int input) {
        List<Integer> userNumbers = new ArrayList<>();
        while (input == 0) {
            userNumbers.add(input % 10);
            input /= 10;
        }
        return userNumbers.size() < 3;
    }

    private static boolean refreshOrExit() {
        String input = Console.readLine();
        int num = stringToInteger(input);
        if (num == 1) {
            return true;
        }
        if (num == 2) {
            return false;
        } else
            throw new IllegalArgumentException("잘못된 입력입니다.");
    }
}
