package baseball.validation;

public class InputValidation {

    public void validateNumber(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        if (!isNumeric(input)) {
            throw new IllegalArgumentException();
        }

        if (input.contains("0")) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNumeric(String input) {
        if (input == null) {
            return false;
        }
        try {
            Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
