package baseball.controller;

import baseball.service.BaseballGameService;
import baseball.view.SystemMessage;
import java.util.Objects;

import static baseball.utils.Constants.GAME_RESTART;
import static baseball.view.UserInput.getUserInputForNewGame;

public class BaseballGameController {

    BaseballGameService baseballGameService = new BaseballGameService();

    public void run() {
        setBaseballGame();
        playingBaseballGame();
        baseballGameOver();
        baseballGameRestartOrNot();
    }

    private void setBaseballGame() {
        baseballGameService.setBaseballGame();
    }

    private void playingBaseballGame() {
        baseballGameService.playingBaseballGame();
    }

    private void baseballGameOver() {
        SystemMessage.printWinMessage();
    }

    private void baseballGameRestartOrNot() {
        SystemMessage.printGameRestartMessage();
        String userInput = getUserInputForNewGame();
        if (Objects.equals(userInput, GAME_RESTART)) {
            run();
        }
    }
}
