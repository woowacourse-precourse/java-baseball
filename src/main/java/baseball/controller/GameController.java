package baseball.controller;

import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class GameController {
    private static InputView inputView = new InputView();
    private static RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public void GameController() {
        inputView.GameStart();
        ArrayList<Integer> computer = randomNumberGenerator.RandomNumberGenerator();
        inputView.InputUserNum();
        String userInputNum = Console.readLine();
        ArrayList<Integer> UserNumList = new InputUserNumber().InputUserNumber(userInputNum);
    }
}