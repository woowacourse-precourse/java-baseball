package baseball.mvc.view;

import baseball.domain.game.GameResult;

public enum GameHintView {
    ONLY_STRIKE("%d스트라이크"),

    ONLY_BALL("%d볼"),

    STRIKE_AND_BALL("%d볼 %d스트라이크"),

    NOTHING("낫싱");

    private final String message;

    GameHintView(String message) {
        this.message = message;
    }

    public static void printGameHintLog(GameResult gameResult) {
        System.out.println(getGameHintLog(gameResult));
    }

    private static String getGameHintLog(GameResult gameResult) {
        if (gameResult.isStrikeAndBall()) {
            return String.format(GameHintView.STRIKE_AND_BALL.message, gameResult.getBall(), gameResult.getStrike());
        }
        if (gameResult.isOnlyStrike()) {
            return String.format(GameHintView.ONLY_STRIKE.message, gameResult.getStrike());
        }
        if (gameResult.isOnlyBall()) {
            return String.format(GameHintView.ONLY_BALL.message, gameResult.getBall());
        }
        return GameHintView.NOTHING.message;
    }
}
