package baseball.controller;

public enum GameFlag {
    START(1),
    END(2);

    private final int flagValue;

    GameFlag(int flagValue) {
        this.flagValue = flagValue;
    }

    public int getFlagValue() {
        return flagValue;
    }
}
