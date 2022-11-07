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
        start();
    }

    public void start() {
        GameScreen.printUserInput();
        String playerInputNumbers = Console.readLine();
        baseballGameService.newGame(playerInputNumbers);
        play();
    }

    public void play() {
        boolean isClear = false;
        while (!isClear) {
            isClear = guessNumber();
        }
        GameScreen.printGameEnd();
        askRestart();
    }

    public boolean guessNumber() {
        GameScreen.printUserInput();
        String playerInputNumbers = Console.readLine();
        GameResult gameResult = baseballGameService.playGame(playerInputNumbers);
        GameScreen.printGameResult(gameResult);

        return gameResult.isAllStrike();
    }

    private void askRestart() {
        GameScreen.printAskNewGame();
        int playerPressKey = Integer.parseInt(Console.readLine());

        if (playerPressKey != NEW_GAME && playerPressKey != GAME_EXIT) {
            throw new IllegalArgumentException();
        }
        if (playerPressKey == NEW_GAME) {
            start();
        }
    }
}
