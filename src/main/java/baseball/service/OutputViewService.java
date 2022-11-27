package baseball.service;

import baseball.view.OutputView;

public class OutputViewService {

    private final int strikeCount;
    private final int ballCount;

    public OutputViewService(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public void test() {
        if (strikeCount != 0 && ballCount == 0)  {
            OutputView.printStrike(strikeCount);
        }

        if (strikeCount == 0 && ballCount != 0) {
            OutputView.printBall(ballCount);
        }

        if (strikeCount != 0 && ballCount != 0) {
            OutputView.printBallAndStrike(ballCount, strikeCount);
        }

        if (strikeCount == 0 && ballCount == 0) {
            OutputView.printNothing();
        }
    }

    public static OutputViewService of(int strikeCount, int ballCount) {
        return new OutputViewService(strikeCount, ballCount);
    }
}
