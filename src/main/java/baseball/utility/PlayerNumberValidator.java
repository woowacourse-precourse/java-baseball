package baseball.utility;

import baseball.constant.GameConstant;

public class PlayerNumberValidator {

    private PlayerNumberValidator() {

    }

    private static boolean isPlayerNumberLengthValid(String playerNumber) {
        return playerNumber.length() == GameConstant.VALID_NUMBER_LENGTH.getValue();
    }
}
