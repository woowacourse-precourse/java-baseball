package baseball.domain.model;

public class Result {
    private final Score score;
    private final boolean isOut;

    public Result(Score score, boolean isOut) {
        this.score = score;
        this.isOut = isOut;
    }

    public boolean isOut() {
        return isOut;
    }

    public Score getScore() {
        return score;
    }
}
