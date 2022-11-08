package baseball.utility;

import baseball.constant.GameConstant;

public class PlayerNumberValidator {
    private static final String ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE = "올바르지 않은 사용자 입력";

    private PlayerNumberValidator() {

    }

    public static void throwIllegalArgumentExceptionIfPlayerNumberNotValid(String playerNumberOrNull) {
        if (isPlayerNumberValid(playerNumberOrNull)) {
            return;
        }
        throw new IllegalArgumentException(
                String.format("%s. 입력된 값 = %s", ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE, playerNumberOrNull)
        );
    }

    private static boolean isPlayerNumberValid(String playerNumberOrNull) {
        if (playerNumberOrNull == null) {
            return false;
        }

        String playerNumber = playerNumberOrNull;

        if (!isPlayerNumberLengthValid(playerNumber)) {
            return false;
        }

        boolean[] checkArray = new boolean[9];
        int index = 0;

        while (index < GameConstant.VALID_NUMBER_LENGTH.getValue()
                && isNumericLiteralBetweenOneAndNine(playerNumber.charAt(index))
                && !isDuplicateNumericLiteral(playerNumber.charAt(index), checkArray)
        ) {
            checkArray[playerNumber.charAt(index) - '1'] = true;
            index++;
        }

        return index == GameConstant.VALID_NUMBER_LENGTH.getValue();
    }

    private static boolean isPlayerNumberLengthValid(String playerNumber) {
        return playerNumber.length() == GameConstant.VALID_NUMBER_LENGTH.getValue();
    }

    private static boolean isNumericLiteralBetweenOneAndNine(char c) {
        return c >= '1' && c <= '9';
    }

    private static boolean isDuplicateNumericLiteral(char numericLiteral, boolean[] checkArray) {
        assert (isNumericLiteralBetweenOneAndNine(numericLiteral));
        assert (checkArray != null);

        return checkArray[numericLiteral - '1'];
    }
}
