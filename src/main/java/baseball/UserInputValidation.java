package baseball;

public class UserInputValidation {

    private static final int NUMBER_LENGTH = 3;

    private boolean isThreeLength(String input) {
        if (input.length() == NUMBER_LENGTH) {
            return true;
        }
        return false;
    }
}
