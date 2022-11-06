package baseball;

public class UserInputValidation {

    private static final int NUMBER_LENGTH = 3;

    private boolean isThreeLength(String input) {
        if (input.length() == NUMBER_LENGTH) {
            return true;
        }
        return false;
    }

    private boolean isInteger(String input) {
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
