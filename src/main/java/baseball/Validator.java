package baseball;

import static baseball.Game.GAME_LENGTH;

public class Validator {
    public void validatePitchValue(String pitchValue) {
        if (!validateGameNumberLength(pitchValue)) {
            throw new IllegalArgumentException("3자리 수를 입력해주세요.");
        }
    }

    private boolean validateGameNumberLength(String value) {
        return value.length() == GAME_LENGTH;
    }
}
