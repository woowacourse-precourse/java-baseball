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
        doGameUntilUserQuit();
    }

    private void doGameUntilUserQuit() {
        int control;
        do {
            baseballGame.initComputerNumber();
            doGameLoopUntilGameOver();
            control = inputView.readGameControlInput();
        } while(control != SystemConstant.GAME_EXIT_CODE);
    }

    private void doGameLoopUntilGameOver() {
       Score userScore;
       do {
           int userNumber = inputView.readGameInput();
           userScore = baseballGame.computeUserScore(userNumber);
           outputView.printResult(userScore);
       } while(!userScore.isGameOver());
    }
}
