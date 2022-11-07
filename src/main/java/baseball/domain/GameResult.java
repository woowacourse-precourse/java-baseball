package baseball.domain;

import baseball.view.Message;

public class GameResult {

    private int strikeCount;
    private int ballCount;

    public GameResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void show() {
        Message.showGameResultMessage(strikeCount, ballCount);
    }
}
