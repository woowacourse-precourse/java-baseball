package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.PlayerNumber;
import baseball.model.Umpire;
import baseball.validator.PlayerInputValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameController {
    public void play() {
        boolean gameFlag = true;
        OutputView.startGameMessage();

        while (gameFlag) {
            startGame();
            gameFlag = restartOrEnd();
        }
        OutputView.endGameMessage();
    }

    public void startGame() {
        ComputerNumber computerNumber = new ComputerNumber();
        PlayerNumber playerNumber = new PlayerNumber();
        Umpire umpire = new Umpire();
        List<Integer> computerNum = computerNumber.getComputerNum();

        while (umpire.getStrike() != 3) {
            List<Integer> playerNum = playerNumber.getPlayerNum();
            String baseballGameResult = umpire.gameResult(computerNum, playerNum);
            System.out.println(baseballGameResult);
        }
        OutputView.clearGameMessage();
    }

    public boolean restartOrEnd() {
        String playerInput = InputView.restartOrEndMessage();

        PlayerInputValidator.restartOrEndValidate(playerInput);
        if (playerInput.equals("1")) {
            return true;
        }
        else {
            return false;
        }
    }
}
