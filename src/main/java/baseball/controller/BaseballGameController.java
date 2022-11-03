package baseball.controller;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {

    private Computer computer;
    private Player player;
    private InputView inputView;
    private OutputView outputView;

    public void start() {
        inputView = new InputView();
        inputView.inputInit();
        String input = inputView.playerInput();

        player = new Player(input);
        player.checkException();
        player.setInputNum();

        computer = new Computer();
        computer.generateComputerNumberThree();

        String hint = computer.getHint(computer.getComputerNumber(), player.getInputNum());

        outputView = new OutputView();
        outputView.printHint(hint);

    }




}
