package baseball.controller;

import baseball.domain.dto.Score;
import baseball.system.SystemConstant;
import baseball.domain.BaseballGame;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameManager {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BaseballGame baseballGame = new BaseballGame();

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.\n";

    public void run() {
        System.out.println(GAME_START_MESSAGE);
        startFirstGame();
        startRepeatedGame();
    }

    private void startFirstGame() {
        startLoop();
    }

    private void startRepeatedGame() {
        int flag = inputView.readGameControlInput();
        if (flag == SystemConstant.GAME_EXIT_CODE) {
            return;
        }
        baseballGame.initComputerNumber();
        startLoop();
        startRepeatedGame();
    }

    private void startLoop() {
        Score userScore;
        do {
            outputView.printMessageForData(OutputMsgContainer.GAME_INPUT_MESSAGE);

            userScore = baseballGame.computeUserScore(inputView.readGameInput());
            outputView.printMessageForData(userScore);
        } while (!isGameOver(userScore));
        outputView.printMessageForData(OutputMsgContainer.GAME_END_AND_RESTART_MESSAGE);
    }

    private boolean isGameOver(Score userScore) {
        return userScore.isGameOver();
    }
}
