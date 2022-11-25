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
    private final String GAME_END_AND_RESTART_MESSAGE =
            SystemConstant.GAME_DIGIT + "개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                    "게임을 새로 시작하려면 " + SystemConstant.GAME_RESTART_CODE +
                    ", 종료하려면 " + SystemConstant.GAME_EXIT_CODE + "를 입력하세요.\n";

    public void run() {
        System.out.println(GAME_START_MESSAGE);
        baseballGame.initComputerNumber();
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
            userScore = baseballGame.computeUserScore(inputView.readGameInput());
            outputView.printResult(userScore);
        } while (!isGameOver(userScore));
        System.out.println(GAME_END_AND_RESTART_MESSAGE);
    }

    private boolean isGameOver(Score userScore) {
        return userScore.isGameOver();
    }
}
