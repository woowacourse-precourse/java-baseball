package baseball.utils;

public class Validator {
    
    public static void isLengthThree(String input) {
        if (input.length() != Constants.NUMBERS_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LENGTH_EXCEPTION);
        }
    }

    public static void isAllNumber(String input) {
        for (int i = 0; i < Constants.NUMBERS_SIZE; i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER_EXCEPTION);
            }
        }
    }

    public static void isOneOrTwo(String input) {
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_ONE_OR_TWO_EXCEPTION);
        }
    }
}
