package baseball.controller;

import baseball.model.GameResult;
import baseball.service.BaseballGameService;
import baseball.view.GameScreen;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGameController {
    private static final int NEW_GAME = 1;
    private static final int GAME_EXIT = 2;

    private final BaseballGameService baseballGameService = new BaseballGameService();

    public void run() {
        GameScreen.printGameStart();
        newGame();
    }

    public void newGame() {
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
        int playerPressKey = Integer.parseInt(Console.readLine());

        if (playerPressKey != NEW_GAME && playerPressKey != GAME_EXIT) {
            throw new IllegalArgumentException();
        }
        if (playerPressKey == NEW_GAME) {
            newGame();
        }
    }
}
