package baseball.model;

public enum SystemScoreModel {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱"),
    ZERO("");

    private final String score;

    SystemScoreModel(final String score) {
        this.score = score;
    }
    public String getScore() {
        return score;
    }
}
