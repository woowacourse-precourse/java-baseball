package baseball;

public enum BaseballScore {
    STRIKE("스트라이크"), BALL("볼"), NOTHING("낫싱");

    public final String scoreName;

    BaseballScore(String score) {
        this.scoreName = score;
    }

    public String getScoreName() {
        return scoreName;
    }
}

