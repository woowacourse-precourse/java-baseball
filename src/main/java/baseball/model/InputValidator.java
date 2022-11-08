package baseball.model;

public class InputValidator {
    public static void validateGameNumberInput(String input) {
        checkNumberLength(input);
        checkAllDigit1To9(input);
        checkAllDigitNotDuplicate(input);
    }

    private static void checkNumberLength(String input) {
        if(input == null || input.length() != GameNumber.GAME_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkAllDigit1To9(String input) {
        if(input == null || !input.matches("^[1-9]+")) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkAllDigitNotDuplicate(String input) {
        if(input == null) {
            throw new IllegalArgumentException();
        }

        for(int i = 0; i < input.length() - 1; i++) {
            char currentChar = input.charAt(i);
            String nextToTail = input.substring(i + 1);

            if(nextToTail.indexOf(currentChar) != -1) {
                throw new IllegalArgumentException();
            }
        }
    }
}
