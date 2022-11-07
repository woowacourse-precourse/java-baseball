package baseball.controller;

import baseball.model.GameResult;
import baseball.service.GameService;
import baseball.util.GameNumberGenerator;
import baseball.util.InputValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final GameService gameService;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
        gameService = GameService.getInstance();
    }

    public void playGame() {
        while (playOneGame().equals(InputValidator.RETRY_GAME)) {
        }
    }

    public String playOneGame() {
        outputView.printStart();
        outputView.printInputNumber();
        String gameNumber = gameService.createNumber();
        //System.out.println("gameNumber = " + gameNumber);
        do {
            String inputNumber = inputView.inputNumber();
            GameResult result = gameService.judge(inputNumber);
            outputView.printResult(result);
            if (result.getStrike() == GameNumberGenerator.GAME_NUMBER_LENGTH) {
                break;
            }
        } while (true);
        outputView.printEnd();
        outputView.printInputRetry();
        return inputView.inputRetry();
    }
}
