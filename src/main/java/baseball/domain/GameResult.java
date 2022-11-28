package baseball.domain;

import baseball.view.OutputView;

public class GameResult {
    private final int ballCount;
    private final int strikeCount;

    public GameResult(int ball, int strike) {
        this.ballCount = ball;
        this.strikeCount = strike;
    }

    public void showResult() {
        OutputView.printResult(ballCount, strikeCount);
    }

    public boolean isSuccess() {
        return strikeCount == 3;
    }

    @Override
    public String toString() {
        return "GameResult{" +
                "ballCount=" + ballCount +
                ", strikeCount=" + strikeCount +
                '}';
    }
}