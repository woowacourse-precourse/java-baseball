package baseball.controller;

import baseball.utils.SystemConstant;
import baseball.domain.BaseballManager;
import baseball.domain.BaseballNumber;
import baseball.view.InputHandler;
import baseball.view.OutputHandler;

import java.util.List;

import static baseball.view.OutputMsgContainer.*;

public class GameManager {
    private final InputHandler inputStream = new InputHandler();
    private final OutputHandler outputStream = new OutputHandler();
    private final BaseballManager baseballManager = new BaseballManager();

    public void run() {
        startFirstGame();
        startRepeatedGame();
    }

    private void startFirstGame() {
        outputStream.printMessageForData(GAME_START_MESSAGE);
        startLoop();
    }

    private void startRepeatedGame() {
        int flag = inputStream.readGameControlInput();
        if (flag == SystemConstant.GAME_EXIT_CODE) {
            return;
        }
        baseballManager.initComputerNumber();
        startLoop();
        startRepeatedGame();
    }

    private void startLoop() {
        List<Integer> userScore;
        do {
            printMessage(GAME_INPUT_MESSAGE);
            int userInput = inputStream.readGameInput();
            baseballManager.addUserBaseballNumInfo(new BaseballNumber(userInput));
            baseballManager.computeUserScore();
            userScore = baseballManager.getUserScore();
            outputStream.printMessageForData(userScore);
        } while (!isGameOver(userScore));
        outputStream.printMessageForData(GAME_END_AND_RESTART_MESSAGE);
    }

    private boolean isGameOver(List<Integer> userScore) {
        return userScore.get(1) == SystemConstant.GAME_DIGIT;
    }
}
