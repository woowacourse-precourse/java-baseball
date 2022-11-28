package baseball.controller;

import baseball.model.game.*;
import baseball.model.number.*;
import baseball.util.constant.GameCommandConst;
import baseball.view.InputView;
import baseball.view.OutputView;

public enum GameController {
    INSTANCE;

    public static void startGame() {
        Game game = GameInitializer.initializeGame();
        progress(game);
        endGame();
    }

    private static void progress(Game game) {
        while (true) {
            NumberCollection playerNumbers = PlayerNumberController.getPlayerNumbers();
            GameResult gameResult = game.getResultOf(playerNumbers);
            printGameResult(gameResult);

            if (gameResult.isAllStrike()) {
                return;
            }
        }
    }

    private static void printGameResult(GameResult gameResult) {
        String message = gameResult.getMessage();
        OutputView.printGameResult(message);
    }

    private static void endGame() {
        OutputView.printGameEnd();
        if (selectRestart()) {
            startGame();
        }
    }

    private static boolean selectRestart() {
        String input = InputView.readGameCommand();
        return input.equals(GameCommandConst.RESTART);
    }
}
