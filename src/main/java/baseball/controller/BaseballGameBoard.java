package baseball.controller;

import baseball.model.ComputerNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;
import static baseball.model.StatusCode.*;

public class BaseballGameBoard {

    public void playTheGame() {
        do {
            startGame();
        } while (!exit());
    }

    private static void startGame() {
        List<Integer> numberGeneratedByComputer = new ComputerNumberGenerator().VALIDATED_NUM;
        do {
            new OutputView()
        }while ()
    }

    private static boolean exit() throws IllegalArgumentException {
        String gameEndNumber = InputView.gameEndInput();
        if (gameEndNumber.equals(RESTART.getCode()))
            return false;
        if (gameEndNumber.equals(QUIT.getCode()))
            return true;
        throw new IllegalArgumentException();
    }
}
