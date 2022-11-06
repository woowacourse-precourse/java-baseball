package baseball.mvc.view;

import baseball.domain.game.GameResult;

public enum GameResultView {

    ONLY_STRIKE("%d스트라이크"),

    ONLY_BALL("%d볼"),

    STRIKE_AND_BALL("%d볼 %d스트라이크"),

    NOTHING("낫싱");

    private final String message;

    GameResultView(String message) {
        this.message = message;
    }

    public static void printGameResultLog(GameResult gameResult) {
        System.out.println(getGameResultLog(gameResult));
    }

    private static String getGameResultLog(GameResult gameResult) {
        if (gameResult.isStrikeAndBall()) {
            return String.format(GameResultView.STRIKE_AND_BALL.message,
                gameResult.getBall(),
                gameResult.getStrike());
        }
        if (gameResult.isOnlyStrike()) {
            return String.format(GameResultView.ONLY_STRIKE.message, gameResult.getStrike());
        }
        if (gameResult.isOnlyBall()) {
            return String.format(GameResultView.ONLY_BALL.message, gameResult.getBall());
        }
        return GameResultView.NOTHING.message;
    }
}
