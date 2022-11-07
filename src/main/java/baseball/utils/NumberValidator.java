package baseball.utils;

import baseball.status.Comments;
import baseball.status.Constants;

public class NumberValidator {

    private static final String ZERO = "0";

    public static void validate(String clientInput) {
        if (isWrongInput(clientInput)) {
            throw new IllegalArgumentException(Comments.EXCEPTION.getComment());
        }
    }

    private static boolean isWrongInput(String clientInput) {
        return !(checkDuplication(clientInput) && checkInputLength(clientInput)
                && checkInputType(clientInput) && checkZeroDigit(clientInput));
    }

    private static boolean checkDuplication(String clientInput) {
        return clientInput.length() == clientInput.chars().distinct().count();
    }

    private static boolean checkZeroDigit(String clientInput) {
        return !clientInput.contains(ZERO);
    }

    private static boolean checkInputLength(String clientInput) {
        return clientInput.length() == Constants.NUMBER_OF_DIGITS.getNumber();
    }

    private static boolean checkInputType(String clientInput) {
        return clientInput.chars().allMatch(Character::isDigit);
    }
}
