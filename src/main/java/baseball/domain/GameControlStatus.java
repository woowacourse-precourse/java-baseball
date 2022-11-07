package baseball.domain;

public class GameControlStatus {

    public static final int RESTART_VALUE = 1;
    public static final int STOP_VALUE = 2;
    public static final String INVALID_INPUT_MESSAGE = "유효하지 않은 입력입니다.";

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
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }

    private boolean isValidValue() {
        return isRestart() || isStop();
    }

    public boolean isStop() {
        return value == STOP_VALUE;
    }

    public boolean isRestart() {
        return value == RESTART_VALUE;
    }
}
