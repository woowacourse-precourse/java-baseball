package baseball.controller;

import baseball.domain.dto.Score;
import baseball.system.SystemConstant;
import baseball.domain.BaseballManager;
import baseball.domain.BaseballNumber;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.view.OutputMsgContainer;

import java.util.List;

public class GameManager {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BaseballManager baseballManager = new BaseballManager();

    public void run() {
        startFirstGame();
        startRepeatedGame();
    }

    private void startFirstGame() {
        outputView.printMessageForData(OutputMsgContainer.GAME_START_MESSAGE);
        startLoop();
    }

    private void startRepeatedGame() {
        int flag = inputView.readGameControlInput();
        if (flag == SystemConstant.GAME_EXIT_CODE) {
            return;
        }
        baseballManager.initComputerNumber();
        startLoop();
        startRepeatedGame();
    }

    private void startLoop() {
        Score userScore;
        do {
            outputView.printMessageForData(OutputMsgContainer.GAME_INPUT_MESSAGE);

            baseballManager.addUserBaseballNumInfo(
                    new BaseballNumber(inputView.readGameInput()));
            baseballManager.computeUserScore();
            userScore = baseballManager.computeUserScore();

            outputView.printMessageForData(userScore);
        } while (!isGameOver(userScore));
        outputView.printMessageForData(OutputMsgContainer.GAME_END_AND_RESTART_MESSAGE);
    }

    private boolean isGameOver(Score userScore) {
        return userScore.isGameOver();
    }
}
