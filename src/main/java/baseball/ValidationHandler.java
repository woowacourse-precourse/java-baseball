package baseball;

public class ValidationHandler {

    private final int NUMBER_LENGTH = 3;
    private final String inputString;

    ValidationHandler(String inputString) {
        this.inputString = inputString;
    }

    public boolean validateNumberLength() {
        if (inputString.length() == NUMBER_LENGTH) {
            return true;
        }

        return false;
    }
}
