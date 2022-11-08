package baseball.util;

import baseball.controller.GameController;

public class ValidationUtil {
    public static void validateInputNumber(String input) {
        if (input.length() == 3 && (!input.contains("0"))
                && validateIsDigit(input) && validateDuplicateNumber(input)) {
            return;
        }
        System.out.println("잘못된 입력입니다.");
        throw new IllegalArgumentException();
    }

    private static boolean validateIsDigit(String input) {
        char[] inputArray = input.toCharArray();
        for (char inputChar : inputArray) {
            if (Character.isDigit(inputChar)) {
                return true;
            }
        }
        return false;
    }

    private static boolean validateDuplicateNumber(String input) {
        char[] charArray = input.toCharArray();
        if (charArray[0] == charArray[1] || charArray[0] == charArray[2]
                || charArray[1] == charArray[2]) {
            return false;
        }
        return true;
    }

    public static void validateInputRestart(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            System.out.println("잘못된 입력입니다.");
            throw new IllegalArgumentException();
        }
        if (input.equals("1")) {
            GameController gameController = new GameController();
            gameController.startGame();
        }
        if (input.equals("2")) {
            return;
        }
    }
}

