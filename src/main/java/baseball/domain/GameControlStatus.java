package baseball.domain;

import baseball.enums.ErrorMessage;
import baseball.enums.GameControl;

public class GameControlStatus {

    private int value;

    public GameControlStatus(int num) {
        value = num;
        validateValue();
    }

    public int getValue() {
        return value;
    }

    private void validateValue() {
        if(!isValidValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.value());
        }
    }

    private boolean isValidValue() {
        return isRestart() || isStop();
    }

    public boolean isStop() {
        return value == GameControl.STOP_VALUE.getValue();
    }

    public boolean isRestart() {
        return value == GameControl.RESTART_VALUE.getValue();
    }
}
