package baseball.dto;

public class Score {
    private final int numBalls;
    private final int numStrikes;

    public Score(int numBalls, int numStrikes) {
        this.numBalls = numBalls;
        this.numStrikes = numStrikes;
    }

    public int getBallCount() {
        return this.numBalls;
    }
}
