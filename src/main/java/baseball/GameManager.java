package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.SystemMsgPrinter.*;

public class GameManager {
    private InputHandler inputStream;
    private OutputHandler outputStream;
    private BaseballManager baseballManager;

    public void run() {
        init();
        startFirstGame();
        startRepeatedGame();
    }

    private void init() {
        inputStream = new InputHandler();
        outputStream = new OutputHandler();
        baseballManager = new BaseballManager();
    }

    private boolean isGameOver(List<Integer> userScore) {
        return userScore.get(1) == SystemConstant.GAME_DIGIT;
    }

    private void startFirstGame() {
        printGameStartMessage();
        startLoop();
    }



}
