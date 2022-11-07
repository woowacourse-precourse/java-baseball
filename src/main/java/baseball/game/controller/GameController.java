package baseball.game.controller;

import baseball.game.dto.BallCount;
import baseball.game.service.GameService;
import baseball.game.view.InputView;
import baseball.game.view.OutputView;

public class GameController {
    private final OutputView outputView;
    private final InputView inputView;
    private final GameService gameService;

    public GameController() {
        outputView = new OutputView();
        inputView = new InputView();
        gameService = new GameService();
    }

    public void play() {
        outputView.printGameStart();
        gameService.computeComputerNumbers();

        while (true) {
            String userNumbers = inputView.inputNumbers();
            gameService.setUserNumbers(userNumbers);

            BallCount ballCount = gameService.computeBallCount();
            outputView.printBallCount(ballCount);
            if (gameService.isFinishGame(ballCount)) {
                outputView.printFinishGame();
                String restartStatus = inputView.inputRestartStatus();
                if(restartStatus.equals("1")){
                    gameService.computeComputerNumbers();
                    continue;
                }
                break;
            }
        }
    }
}
