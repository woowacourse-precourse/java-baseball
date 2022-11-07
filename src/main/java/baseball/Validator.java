package baseball;

import static baseball.Game.GAME_LENGTH;

public class Validator {
    public void validatePitchValue(String pitchValue) {
        if (!validateGameNumberLength(pitchValue)) {
            throw new IllegalArgumentException("3자리 수를 입력해주세요.");
        }

        if (!validateIsAllDigitExceptForZero(pitchValue)) {
            throw new IllegalArgumentException("0을 제외한 숫자만 입력해주세요.");
        }
    }

    private boolean validateGameNumberLength(String value) {
        return value.length() == GAME_LENGTH;
    }

    private boolean validateIsAllDigitExceptForZero(String value) {
        for (int idx = 0; idx < value.length(); idx++) {
            if (!Character.isDigit(value.charAt(idx))) {
                return false;
            }
            if (value.charAt(idx) == '0') {
                return false;
            }
        }
        return true;
    }
}
