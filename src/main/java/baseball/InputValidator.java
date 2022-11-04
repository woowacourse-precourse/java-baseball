package baseball;

public class InputValidator {
    public static void checkIsValidThreeNumbers(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < userInput.length(); i++) {
            if (!Character.isDigit(userInput.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
    }
}
