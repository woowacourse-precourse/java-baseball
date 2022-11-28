package baseball.view;

import baseball.model.GameResult;
import baseball.util.GameControllerMessage;

public enum OutputView {
    INSTANCE;

    public static void printApplicationStart() {
        System.out.println(GameControllerMessage.GAME_START);
    }

    public static void printGameResult(GameResult gameResult) {
        System.out.println(gameResult.getMessage());
    }

    public static void printGameEnd() {
        System.out.println(GameControllerMessage.GAME_END);
    }
}
