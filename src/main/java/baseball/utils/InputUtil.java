package baseball.utils;


import camp.nextstep.edu.missionutils.Console;

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
