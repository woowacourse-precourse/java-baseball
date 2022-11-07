package baseball.exception;


public class InputException {
    private static final int EXPECTED_NUMBER_OF_USER_LENGTH = 3;

    public static String isExpectedNumberOfUserValid(String expectedNumberOfUser) {
        if (!isLengthThree(expectedNumberOfUser)) {
            throw new IllegalArgumentException();
        }
        if (!isThreeDifferentDigits(expectedNumberOfUser) || !isNumberBetweenOneAndNine(expectedNumberOfUser)) {
            throw new IllegalArgumentException();
        }
        return expectedNumberOfUser;
    }

    public static String isValueOfRestartGameOrNotValid(String valueOfRestartGameOrNot) {
        if (!isValueOfOneOrTwo(valueOfRestartGameOrNot)) {
            throw new IllegalArgumentException();
        }
        return valueOfRestartGameOrNot;
    }

    private static boolean isLengthThree(String expectedNumberOfUser) {
        return expectedNumberOfUser.length() == EXPECTED_NUMBER_OF_USER_LENGTH;
    }

    private static boolean isThreeDifferentDigits(String expectedNumberOfUser) {
        char firstDigit = expectedNumberOfUser.charAt(0);
        char secondDigit = expectedNumberOfUser.charAt(1);
        char thirdDigit = expectedNumberOfUser.charAt(2);
        if (firstDigit == secondDigit || firstDigit == thirdDigit || secondDigit == thirdDigit) {
            return false;
        }
        return true;
    }

    private static boolean isNumberBetweenOneAndNine(String expectedNumberOfUser) {
        for (int i = 0; i < EXPECTED_NUMBER_OF_USER_LENGTH; i++) {
            if (expectedNumberOfUser.charAt(i) < '1' || expectedNumberOfUser.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    private static boolean isValueOfOneOrTwo(String valueOfRestartGameOrNot) {
        if (valueOfRestartGameOrNot.equals("1") || valueOfRestartGameOrNot.equals("2")) {
            return true;
        }
        return false;
    }
}
