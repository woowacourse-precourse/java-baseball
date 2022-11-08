package baseball.controller;

import baseball.model.ComputerNumberGenerator;
import baseball.model.UserNumberGenerator;
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
        List<Integer> numberGeneratedByUser;
        boolean matchedAllNumber;
        do {
            numberGeneratedByUser = new UserNumberGenerator().VALIDATED_NUM;
            BaseballGame game = new BaseballGame(numberGeneratedByUser, numberGeneratedByComputer);
            new OutputView(game).printGameResult();
            matchedAllNumber = game.matchedAllNumber();
        } while (!matchedAllNumber);
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
