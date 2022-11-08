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

        while (gameFlag) {
            OutputView.startGameMessage();
            startGame();
            gameFlag = restartOrEnd();
        }
    }

    public void startGame() {
        int strikeCount = 0;
        List<Integer> computerNumList = new ArrayList<>();
        ComputerNumber computerNum = new ComputerNumber(computerNumList);
        PlayerNumber playerNum = new PlayerNumber();
        Umpire umpire = new Umpire();

        while (strikeCount != 3) {
            String baseballGameResult = umpire.gameResult(computerNum.getComputerNum(), playerNum.getPlayerNum());
            System.out.println(baseballGameResult);
            strikeCount = umpire.getStrike();
        }
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
