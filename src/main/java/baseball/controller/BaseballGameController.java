package baseball.controller;

import baseball.model.GameResult;
import baseball.service.BaseballGameService;
import baseball.view.GameScreen;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGameController {

    private final BaseballGameService baseballGameService = new BaseballGameService();

    public void run() {
        GameScreen.printGameStart();
        startGame();
    }

    public void startGame() {
        baseballGameService.newGame();
        boolean isGameClear = false;
        while (!isGameClear) {
            isGameClear = playGame();
        }
        GameScreen.printGameEnd();
        askRetryGame();
    }

    public boolean playGame() {
        GameScreen.printUserInput();
        String playerInputNumbers = Console.readLine();
        GameResult gameResult = baseballGameService.playGame(playerInputNumbers);
        GameScreen.printGameResult(gameResult);

        return gameResult.isAllStrike();
    }

    private void askRetryGame() {
        GameScreen.printAskNewGame();
        String playerInputKey = Console.readLine();
    }
}
