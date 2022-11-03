package baseball.exception;


public class InputException {
    private static final int USER_INPUT_SIZE = 3;

    public static String isValidInput(String userInput) {
        if (!isLengthThree(userInput)) {
            throw new IllegalArgumentException();
        }
        if (!isThreeDifferentDigits(userInput) || !isNumberBetweenOneAndNine(userInput)) {
            throw new IllegalArgumentException();
        }
        return userInput;
    }

    public static String isOneOrTwo(String userInput) {
        if (!userInput.equals("1") && !userInput.equals("2")) {
            throw new IllegalArgumentException();
        }
        return userInput;
    }

    private static boolean isLengthThree(String userInput) {
        return userInput.length() == USER_INPUT_SIZE;
    }

    public static boolean isThreeDifferentDigits(String userInput) {
        char firstDigit = userInput.charAt(0);
        char secondDigit = userInput.charAt(1);
        char thirdDigit = userInput.charAt(2);
        if (firstDigit == secondDigit || firstDigit == thirdDigit || secondDigit == thirdDigit) {
            return false;
        }
        return true;
    }

    private static boolean isNumberBetweenOneAndNine(String userInput) {
        for (int i = 0; i < USER_INPUT_SIZE; i++) {
            if (userInput.charAt(i) < '1' || userInput.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }
}
