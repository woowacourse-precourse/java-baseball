package baseball.view;

import static baseball.util.Constants.RESULT_SPACE;

import baseball.model.BallCount;
import baseball.model.Result;
import baseball.util.ConsoleMessage;

public class OutputView {

    private enum BallCount {
        STRIKE("스트라이크"),
        BALL("볼"),
        NOTHING("낫싱");

        private final String display;

        BallCount(String display) {
            this.display = display;
        }

        public String getDisplay() {
            return display;
        }
    }

    public void printGameStart() {
        System.out.println(ConsoleMessage.START_GAME.getMessage());
    }

    public void printGameResult(Result result) {
        System.out.println(getFormattedResult(result));
    }

    public void printFullStrike() {
        System.out.println(ConsoleMessage.THREE_STRIKE.getMessage());
    }

    public void printExceptionMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    private String getFormattedResult(Result result) {
        return getDisplay(result.getStrike(), result.getBall());
    }

    private static String getDisplay(int strike, int ball) {

        if (isNothing(strike, ball)) {
            return BallCount.NOTHING.getDisplay();
        }
        return formatBallCount(strike, ball);
    }

    private static String formatBallCount(int strike, int ball) {
        StringBuilder gameResult = new StringBuilder();
        appendBall(ball, gameResult);
        appendSpace(strike, ball, gameResult);
        appendStrike(strike, gameResult);
        return gameResult.toString();
    }

    private static void appendStrike(int strike, StringBuilder gameResult) {
        if (strike > 0) {
            gameResult.append(strike).append(BallCount.STRIKE.getDisplay());
        }
    }

    private static void appendSpace(int strike, int ball, StringBuilder gameResult) {
        if (ball > 0 && strike > 0) {
            gameResult.append(RESULT_SPACE);
        }
    }

    private static void appendBall(int ball, StringBuilder gameResult) {
        if (ball > 0) {
            gameResult.append(ball).append(BallCount.BALL.getDisplay());
        }
    }

    private static boolean isNothing(int strike, int ball) {
        return strike == 0 && ball == 0;
    }
}
