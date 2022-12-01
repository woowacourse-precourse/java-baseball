package baseball.view;

import static baseball.util.Constants.RESULT_SPACE;

import baseball.model.BallCount;
import baseball.model.Result;
import baseball.util.ConsoleMessage;
import baseball.util.ExceptionMessage;

public class OutputView {
    public void printGameStart() {
        System.out.println(ConsoleMessage.START_GAME.getMessage());
    }

    public void printGameResult(Result result) {
        System.out.println(getFormattedResult(result));
    }

    public void printThreeStrike() {
        System.out.println(ConsoleMessage.THREE_STRIKE.getMessage());
    }

    public void printExceptionMessage(Exception exception) {
        System.out.printf(ExceptionMessage.BASE.getMessage(), exception.getMessage());
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
        if (ball > 0) {
            gameResult.append(ball).append(BallCount.BALL.getDisplay());
        }
        if (ball > 0 && strike > 0) {
            gameResult.append(RESULT_SPACE);
        }
        if (strike > 0) {
            gameResult.append(strike).append(BallCount.STRIKE.getDisplay());
        }
        return gameResult.toString();
    }

    private static boolean isNothing(int strike, int ball) {
        return strike == 0 && ball == 0;
    }
}
