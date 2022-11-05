package baseball.domain;

public class GameControlStatus {

    public static final int RESTART_VALUE = 1;
    public static final int STOP_VALUE = 2;

    private int value;

    public GameControlStatus(int num) {
        value = num;
        validateValue();
    }

    public int getValue() {
        return value;
    }

    private void validateValue() {
        if(value != RESTART_VALUE && value != STOP_VALUE) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다.");
        }
    }

    public boolean isRestart() {
        return value == RESTART_VALUE;
    }
}
