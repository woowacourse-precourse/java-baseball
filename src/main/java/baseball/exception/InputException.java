package baseball.exception;


public class InputException {
    private static final int USER_INPUT_SIZE = 3;

    public static String isThreeDifferentDigits(String userInput) {
        char firstDigit = userInput.charAt(0);
        char secondDigit = userInput.charAt(1);
        char thirdDigit = userInput.charAt(2);
        if (firstDigit == secondDigit || firstDigit == thirdDigit || secondDigit == thirdDigit)
            throw new IllegalArgumentException();
        return userInput;
    }
}
