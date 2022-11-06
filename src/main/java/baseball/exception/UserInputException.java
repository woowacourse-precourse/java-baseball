package baseball.exception;

public class UserInputException {

    private final int VALID_LENGTH = 3;

    public boolean isValidLength(String userInput) {
        if (userInput.length() == VALID_LENGTH) {
            return true;
        }
        return false;
    }
}
