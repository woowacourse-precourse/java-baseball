package baseball.game.controller;

import baseball.game.dto.BallCount;
import baseball.game.service.GameService;
import baseball.game.view.InputView;
import baseball.game.view.OutputView;

public class GameController {
    private final OutputView outputView;
    private final InputView inputView;
    private final GameService gameService;
    private final String RESTART_STATUS = "1";

    public GameController() {
        outputView = new OutputView();
        inputView = new InputView();
        gameService = new GameService();
    }

    public void play() {
        setGame();
        startGame();
        finishGame();

        String restartStatus = inputView.inputRestartStatus();
        if (isRestartGame(restartStatus)) {
            play();
        }
    }

    private void finishGame() {
        outputView.printFinishGame();
    }

    private void startGame() {
        while (true) {
            String userNumbers = inputView.inputNumbers();
            gameService.setUserNumbers(userNumbers);

            BallCount ballCount = gameService.computeBallCount();
            outputView.printBallCount(ballCount);

            if (isFinishGame(ballCount)) {
                break;
            }
        }
    }


    private boolean isRestartGame(String restartStatus) {
        if (restartStatus.equals(RESTART_STATUS)) {
            return true;
        }
        return false;
    }

    private boolean isFinishGame(BallCount ballCount) {
        if (gameService.isFinishGame(ballCount)) {
            return true;
        }
        return false;
    }

    private void setGame() {
        outputView.printGameStart();
        gameService.computeComputerNumbers();
    }
}
