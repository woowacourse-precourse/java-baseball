package baseball.game;

import baseball.ball.BallResult;

public class GameResult {
    private final int WIN_CONDITION = 3;
    private static final int ZERO = 0;
    private int ballCount;
    private int strikeCount;

    public GameResult() {
        this.ballCount = ZERO;
        this.strikeCount = ZERO;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void plusScore(BallResult ballResult) {
        if (ballResult.isBall()) {
            ballCount++;
        }
        if (ballResult.isStrike()) {
            strikeCount++;
        }
    }

    public BaseballStatus determineCorrect() {
        if (isWinCondition()) {
            return BaseballStatus.CORRECT;
        }
        return BaseballStatus.GUESSING;
    }

    public boolean isWinCondition() {
        return this.strikeCount == WIN_CONDITION;
    }

    public boolean isBallScoreValid() {
        return this.ballCount > ZERO;
    }

    public boolean isStrikeScoreValid() {
        return this.strikeCount > ZERO;
    }

    public boolean isNoScore() {
        return this.strikeCount == ZERO && this.ballCount == ZERO;
    }
}
