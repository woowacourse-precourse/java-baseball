package baseball.controller;

import baseball.system.SystemConstant;
import baseball.domain.BaseballManager;
import baseball.domain.BaseballNumber;
import baseball.view.InputHandler;
import baseball.view.OutputHandler;
import baseball.view.OutputMsgContainer;

import java.util.List;

public class GameManager {
    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();
    private final BaseballManager baseballManager = new BaseballManager();

    public void run() {
        startFirstGame();
        startRepeatedGame();
    }

    private void startFirstGame() {
        outputHandler.printMessageForData(OutputMsgContainer.GAME_START_MESSAGE);
        startLoop();
    }

    private void startRepeatedGame() {
        int flag = inputHandler.readGameControlInput();
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
            outputHandler.printMessageForData(OutputMsgContainer.GAME_INPUT_MESSAGE);

            baseballManager.addUserBaseballNumInfo(
                    new BaseballNumber(inputHandler.readGameInput()));
            baseballManager.computeUserScore();
            userScore = baseballManager.getUserScore();

            outputHandler.printMessageForData(userScore);
        } while (!isGameOver(userScore));
        outputHandler.printMessageForData(OutputMsgContainer.GAME_END_AND_RESTART_MESSAGE);
    }

    private boolean isGameOver(List<Integer> userScore) {
        return userScore.get(1) == SystemConstant.GAME_DIGIT;
    }
}
