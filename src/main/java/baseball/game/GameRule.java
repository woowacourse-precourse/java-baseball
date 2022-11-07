package baseball.game;

public enum GameRule {
    BASEBALL_MAX_SIZE(3),
    BASEBALL_MIN_NUMBER(1),
    BASEBALL_MAX_NUMBER(9),
    BASEBALL_STRIKE_WIN_COUNT(3);

    private final int rule;

    GameRule(int rule) {
        this.rule = rule;
    }

    public int getRule() {
        return rule;
    }
}
