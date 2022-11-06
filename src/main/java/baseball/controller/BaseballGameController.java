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
            player.setInputNum();

            hint = computer.getHint(computer.getComputerNumber(), player.getInputNum());

            outputView = new OutputView();
            outputView.printHint(hint);
        } while (computer.isNotThreeStrike(hint));
    }

    private void restart() {
        String restartInput = inputView.restart();
        if(computer.isRestart(restartInput)){
            start();
        }
    }


}
