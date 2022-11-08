package baseball.util;

public enum GameCode {

    PLAY(1),
    EXIT(2),
    ATTACK(3),
    CONTINUE(4);

    private final int value;

    GameCode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }


}