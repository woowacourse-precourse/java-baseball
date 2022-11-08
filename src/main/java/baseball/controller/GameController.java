package baseball.controller;

import baseball.service.GameService;
import baseball.view.GameView;
import baseball.model.Result;

public class GameController {
    private static final GameService gameService = GameService.getInstance();
    private static final GameView gameView = GameView.getInstance();

    public static void runGame() throws IllegalArgumentException {
        gameService.refreshComputerNumbers();
        repeatUntilPlayerWin();
        selectRestartOrQuit();
    }

    public static void informExitByError(Exception exception) {
        gameView.showExitMessageByError(exception);
    }

    private static void repeatUntilPlayerWin() throws IllegalArgumentException {
        boolean strikeAll = false;
        while (!strikeAll) {
            String guessingInput = gameView.askGuessingNumbers();
            Result guessResult = gameService.guessNumbers(guessingInput);
            gameView.showHintByResult(guessResult);
            strikeAll = guessResult.strikeAll();
        }
    }

    private static void selectRestartOrQuit() throws IllegalArgumentException {
        if (gameView.askRestartGame()) {
            runGame();
        }
    }
}
