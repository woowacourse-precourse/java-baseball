package baseball.controller;

import baseball.view.GameStart;

public class GameController {
    private static GameStart gameStart = new GameStart();

    public void GameController() {
        gameStart.GameStart();
    }
}