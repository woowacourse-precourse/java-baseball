package baseball.view;

import baseball.domain.GameResult;

public class OutputView {
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String BALL_MESSAGE = "%d볼";
    private static final String STRIKE_MESSAGE = "%d스트라이크";
    private static final String WHOLE_COUNT_MESSAGE = "%d볼 %d스트라이크";

    public static void writeGameResult(GameResult gameResult) {
        String message = getResultMessage(gameResult);
        System.out.println(message);
    }

    private static String getResultMessage(GameResult gameResult) {
        if (gameResult.isNothing()) {
            return NOTHING_MESSAGE;
        }
        if (gameResult.isOnlyBall()) {
            return String.format(BALL_MESSAGE, gameResult.getBallCounts());
        }
        if (gameResult.isOnlyStrike()) {
            return String.format(STRIKE_MESSAGE, gameResult.getStrikeCounts());
        }
        return String.format(WHOLE_COUNT_MESSAGE, gameResult.getBallCounts(), gameResult.getStrikeCounts());
    }
}
