package baseball.controller;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {

    private Computer computer = new Computer();
    private Player player;
    private InputView inputView;
    private OutputView outputView;

    public void start() {

        String hint="";
        inputView = new InputView();
        inputView.inputInit();
        computer.generateComputerNumberThree();

        do {
            String input = inputView.playerInput();

            player = new Player(input);
            player.checkException();
            player.setInputNum();

            hint = computer.getHint(computer.getComputerNumber(), player.getInputNum());

            outputView = new OutputView();
            outputView.printHint(hint);
        } while (computer.getOutcome(hint));
        outputView.printGameEnd();


    }


}
