package baseball.view;

import baseball.controller.BaseballGame;

public class OutputView {

    private final int STRIKE_COUNT;
    private final int BALL_COUNT;

    public OutputView(BaseballGame game) {
        this.STRIKE_COUNT = game.STRIKE_COUNT;
        this.BALL_COUNT = game.BALL_COUNT;
    }

    public void printGameResult() {
        printBallCount();
        printStrikeCount();
        printBallAndStrike();
        printNothing();
    }
}
