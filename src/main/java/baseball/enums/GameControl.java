package baseball.enums;

public enum GameControl {

    RESTART_VALUE(1),
    STOP_VALUE(2);

    private int value;

    GameControl(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
