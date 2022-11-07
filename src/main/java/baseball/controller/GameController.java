package baseball.controller;

import baseball.validator.PlayerInputValidator;
import camp.nextstep.edu.missionutils.Console;

import baseball.model.Computer;
import baseball.model.Player;

import java.util.List;

public class GameController {

    private final PlayerInputValidator playerInputValidator = new PlayerInputValidator();
    private Computer computer;
    private Player player;

    private void initGame() {
        this.player = new Player();
        this.computer = new Computer();
    }

    public void playGame() {
        initGame();
    }

    public void endGame() {

    }

    public void inputPlayerNumbers() {
        String input = Console.readLine();
        List<Integer> inputNumberList = playerInputValidator.getDigitList(input);
        player.setPlayerNumbers(inputNumberList);
    }
}
