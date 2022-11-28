package baseball.view;

import baseball.util.GameControllerMessage;

public enum OutputView {
    INSTANCE;

    public static void printApplicationStart() {
        System.out.println(GameControllerMessage.GAME_START);
    }

    public static void printGameResult(String gameResult) {
        System.out.println(gameResult);
    }

    public static void printGameEnd() {
        System.out.println(GameControllerMessage.GAME_END);
    }
}
