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

    public BaseballGameController(){
        computer = new Computer();
        inputView = new InputView();
        outputView = new OutputView();
        outputView.printGameStart();
    }

    public void start() {

        computer.generateComputerNumberThree();
        play();
        outputView.printGameEnd();
        restartOrClose();

    }

    private void play() {
        String hint;
        do {
            String input = inputView.playerInput();

            player = new Player(input);
            player.checkException();
            player.setInputNumber();

            hint = computer.getHint(computer.getComputerNumber(), player.getInputNumber());

            outputView.printHint(hint);
        } while (computer.isNotThreeStrike(hint));
    }

    public void restartOrClose() {
        String restartInput = inputView.restart();
        restart(restartInput);
    }

    private void restart(String restartInput) {
        if (computer.isRestart(restartInput)) {
            start();
        }
    }

}
