package baseball.type;

public enum GameType {
    WRONG_ANSWER(false);

    private final boolean value;

    GameType(boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }
}
