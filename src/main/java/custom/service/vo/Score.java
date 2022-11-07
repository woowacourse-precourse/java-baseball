package custom.service.vo;

public class Score {
    private final int scoreOfStrike;
    private final int scoreOfBall;

    public Score(int scoreOfStrike, int scoreOfBall) {
        this.scoreOfStrike = scoreOfStrike;
        this.scoreOfBall = scoreOfBall;
    }

    public int getScoreOfStrike() {
        return scoreOfStrike;
    }

    public int getScoreOfBall() {
        return scoreOfBall;
    }
}
