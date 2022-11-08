package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class GameController {
    private static InputView inputView = new InputView();
    private static ComputerNumber computerNumber = new ComputerNumber();

    public void GameController() {
        inputView.GameStart();
        ArrayList<Integer> computerNumber = new ComputerNumber().makeComputerNumber();
        inputView.InputUserNum();
        String userInputNum = Console.readLine();
        ArrayList<Integer> UserNumList = new InputUserNumber().InputUserNumber(userInputNum);
    }
}