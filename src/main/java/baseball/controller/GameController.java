package baseball.controller;

import baseball.model.Computer;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;

public class GameController {
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();
    private static Computer computer = new Computer();
    private static CompareNumbers compare = new CompareNumbers();
    private static HandleException handleException = new HandleException();

    public void GameController() {
        int strike = 0;

        inputView.GameStart();

        while (true) {
            ArrayList<Integer> computerNumber = computer.makeComputerNumber();
            System.out.println(computerNumber);

            while (true) {
                strike = 0;
                String userInputNum = inputView.InputUserNum();
                ArrayList<Integer> UserNumList = new InputUserNumber().InputUserNumber(userInputNum);
                strike = compare.compareNumbers(UserNumList, computerNumber);
                if (strike == 3) {
                    break;
                }
            }

            outputView.printGameEnd();
            int restartOrExit = Integer.parseInt(inputView.RestartOrExit());
            handleException.handleRestartOrExitNumberException(restartOrExit);

            if (restartOrExit == 2) {
                break;
            }
        }

    }
}