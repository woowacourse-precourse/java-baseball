package baseball.controller;

import baseball.domain.BaseballGameStatus;
import baseball.view.OutputView;

public class BaseballGameController {

    private static final OutputView outputView = OutputView.INSTANCE;

    private static BaseballGameStatus gameStatus;

    public static void run() {
        initializeGame();
        while (gameStatus.isPlay()) {
            changeGameStatusToStop();
        }
    }

    private static void initializeGame() {
        outputView.startBaseballGame();
        changeGameStatusToPlay();
    }

    private static void changeGameStatusToPlay() {
        gameStatus = BaseballGameStatus.PLAY;
    }

    private static void changeGameStatusToStop() {
        gameStatus = BaseballGameStatus.STOP;
    }
}
