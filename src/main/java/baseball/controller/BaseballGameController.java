package baseball.controller;

import baseball.model.GameResult;
import baseball.service.BaseballGameService;
import baseball.view.GameScreen;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGameController {
    private static final int NEW_GAME = 1;
    private static final int GAME_EXIT = 2;

    private final BaseballGameService baseballGameService = new BaseballGameService();
    private final GameScreen gameScreen = new GameScreen();
    
    public void run() {
        gameScreen.printStart();
        start();
    }

    public void start() {
        baseballGameService.newGame();
        play();
    }

    public void play() {
        boolean isClear = false;
        while (!isClear) {
            String playerInputNumbers = getPlayerInput();
            isClear = guessNumber(playerInputNumbers);
        }
        gameScreen.printEnd();
        askRestart();
    }

    private String getPlayerInput() {
        gameScreen.printPlayerInput();
        return Console.readLine();
    }

    public boolean guessNumber(String playerInputNumbers) {
        GameResult gameResult = baseballGameService.playGame(playerInputNumbers);
        gameScreen.printResult(gameResult);

        return gameResult.isAllStrike();
    }

    private void askRestart() {
        gameScreen.printAskRestart();
        int playerPressKey = Integer.parseInt(Console.readLine());

        if (playerPressKey != NEW_GAME && playerPressKey != GAME_EXIT) {
            throw new IllegalArgumentException();
        }
        if (playerPressKey == NEW_GAME) {
            start();
        }
    }
}
