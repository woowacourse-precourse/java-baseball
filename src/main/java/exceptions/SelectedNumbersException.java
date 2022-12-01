package exceptions;

public class SelectedNumbersException extends Exception {
    final static String EXCEPTION_AT_VERIFY_UNIQUENESS = "exception occurred at verifyUniqueness";
    final static int NUMBER_LENGTH = 3;

    public static void validate(String playerNumbers) {
        validateCommonException(playerNumbers);
        validateNumericOnly(playerNumbers);
        validateSize(playerNumbers);
        validateUniqueness(playerNumbers);
        validateRange(playerNumbers);
    }

    private static void validateSize(String playerNumbers) {
        if (playerNumbers.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateUniqueness(String playerNumbers) {
        for (int stringIndex = 0; stringIndex < NUMBER_LENGTH; stringIndex++) {
            if (playerNumbers.lastIndexOf(playerNumbers.charAt(stringIndex)) != stringIndex) {
                throw new IllegalArgumentException(EXCEPTION_AT_VERIFY_UNIQUENESS);
            }
        }
    }

    private static void validateRange(String input) {
        String regex = "^[1-9]*$";
        if (!input.matches(regex)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNumericOnly(String input) {
        String regex = "^[0-9]*$";
        if (!input.matches(regex)) {
            throw new IllegalArgumentException();
        }
    }
}
