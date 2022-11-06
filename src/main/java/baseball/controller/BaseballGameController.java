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

        inputView = new InputView();
        inputView.inputInit();
        computer.generateComputerNumberThree();
        play();
        outputView.printGameEnd();
        restart();

    }

    private void play() {
        String hint;
        do {
            String input = inputView.playerInput();

            player = new Player(input);
            player.checkException();
            player.setInputNumber();

            hint = computer.getHint(computer.getComputerNumber(), player.getInputNumber());

            outputView = new OutputView();
            outputView.printHint(hint);
        } while (computer.isNotThreeStrike(hint));
    }

    public void restart() {
        String restartInput = inputView.restart();
        System.out.println(restartInput);
        if (computer.isRestart(restartInput)) {
            start();
        }
    }

    public void setInputView(InputView inputView){
        this.inputView = inputView;
    }
}
