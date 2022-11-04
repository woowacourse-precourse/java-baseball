package baseball;

public class InputValidator {
    public static void checkIsValidThreeNumbers(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException();
        }
    }
}
