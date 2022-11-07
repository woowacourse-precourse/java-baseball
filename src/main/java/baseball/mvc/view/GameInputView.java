package baseball.mvc.view;

import baseball.util.GameStatus;
import java.util.Arrays;
import java.util.function.Consumer;

public enum GameInputView {
    ANSWER_INPUT("숫자를 입력해주세요 : ",
            GameStatus.PLAY,
            System.out::print),

    RESTART_INPUT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.",
            GameStatus.END,
            System.out::println);

    private final String message;
    private final GameStatus gameStatus;
    private final Consumer<String> printLog;

    GameInputView(String message, GameStatus gameStatus, Consumer<String> printLog) {
        this.message = message;
        this.gameStatus = gameStatus;
        this.printLog = printLog;
    }

    public static void printGameInputLog(GameStatus nowGameStatus) {
        Arrays.stream(GameInputView.values())
                .filter(gamePlayLog -> gamePlayLog.gameStatus == nowGameStatus)
                .forEach(gamePlayLog -> gamePlayLog.printLog.accept(gamePlayLog.message));
    }
}
