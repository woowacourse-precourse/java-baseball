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
        printOnlyBallCount();
        printOnlyStrikeCount();
        printBallAndStrike();
        printNothing();
    }

    private void printOnlyBallCount() {
        if (BALL_COUNT != 0 && STRIKE_COUNT == 0)
            System.out.println(BALL_COUNT + "볼");
    }

    private void printOnlyStrikeCount() {
        if (BALL_COUNT == 0 && STRIKE_COUNT != 0)
            System.out.println(STRIKE_COUNT + "스트라이크");
    }

    private void printBallAndStrike() {
        if (BALL_COUNT != 0 && STRIKE_COUNT != 0)
            System.out.println(BALL_COUNT + "볼 " + STRIKE_COUNT + "스트라이크");
    }

    private void printNothing() {
        if (BALL_COUNT == 0 && STRIKE_COUNT == 0)
            System.out.println("낫싱");
    }
}
