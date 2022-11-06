package baseball.exception;

public class UserInputException {

    private final int VALID_LENGTH = 3;

    public boolean isValidLength(String userInput) {
        if (userInput.length() == VALID_LENGTH) {
            return true;
        }
        return false;
    }

    public boolean isNumber(String userInput) {
        for (int userInputIndex = 0; userInputIndex < userInput.length(); userInputIndex++) {
            if (!Character.isDigit(userInput.charAt(userInputIndex))) {
                return false;
            }
        }
        return true;
    }

    public boolean isNotContainZero(String userInput) {
        if (userInput.contains("0")) {
            return false;
        }
        return true;
    }
}
