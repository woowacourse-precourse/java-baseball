package baseball.utility;

import baseball.constant.GameConstant;

public class PlayerNumberValidator {

    private PlayerNumberValidator() {

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
