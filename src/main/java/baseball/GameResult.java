package baseball;

import static baseball.BaseBallGame.GAME_NUMBER_LENGTH;

public class GameResult {

    private final int ballCount;
    private final int strikeCount;

    public GameResult(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public boolean isFinished() {
        return strikeCount == GAME_NUMBER_LENGTH;
    }

    public int getStrikeCount() {
        return this.strikeCount;
    }

    public int getBallCount() {
        return this.ballCount;
    }
}
