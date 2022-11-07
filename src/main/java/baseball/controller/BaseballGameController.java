package baseball.controller;

import baseball.model.GameResult;
import baseball.service.BaseballGameService;
import baseball.view.GameScreen;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGameController {
    private static final int NEW_GAME = 1;
    private static final int GAME_EXIT = 2;

    private final BaseballGameService baseballGameService = new BaseballGameService();

    public void start() {
        GameScreen.printGameStart();
        run();
    }

    public void run() {
        newGame();
        playGame();
        askRetryGame();
    }

    public void newGame() {
        String playerInputNumbers = receiveInput();
        baseballGameService.newGame(playerInputNumbers);
    }

    public void playGame() {
        boolean isGameClear = false;
        while (!isGameClear) {
            isGameClear = guessNumber();
        }
        GameScreen.printGameEnd();
    }

    public boolean guessNumber() {
        String playerInputNumbers = receiveInput();
        GameResult gameResult = baseballGameService.playGame(playerInputNumbers);
        GameScreen.printGameResult(gameResult);

        return gameResult.isAllStrike();
    }

    private String receiveInput() {
        GameScreen.printUserInput();

        return Console.readLine();
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
