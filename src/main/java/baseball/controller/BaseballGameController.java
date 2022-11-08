package baseball.controller;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.model.Umpire;
import baseball.validator.PlayerInputValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

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
        Computer computer = new Computer();
        Player player = new Player();
        Umpire umpire = new Umpire();
        List<Integer> computerNum = computer.getComputerNum();

        while (umpire.getStrike() != 3) {
            List<Integer> playerNum = player.getPlayerNum();
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
        return false;
    }
}
