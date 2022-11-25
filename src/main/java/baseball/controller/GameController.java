package baseball.controller;

import baseball.model.Computer;
import baseball.model.User;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView =outputView;
    }

    public void play() {
        outputView.printStartGame();
        // create numbers of computer
        Computer computer = new Computer();
        List<Integer> computerNumber = computer.getComputerNumber();

        // get numbers from user
        outputView.printUserNumberInput();
        User user = new User(inputView.readUserNumber());

        // compare computer numbers and user numbers
        // count strike, ball
        // print result
    }
}
