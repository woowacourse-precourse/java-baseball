package baseball.controller;

import baseball.view.InputView;

import java.util.ArrayList;

public class GameController {
    private static InputView inputView = new InputView();
    private static RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public void GameController() {
        inputView.GameStart();
        ArrayList<Integer> computer = randomNumberGenerator.RandomNumberGenerator();
    }
}