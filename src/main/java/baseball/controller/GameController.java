package baseball.controller;

import baseball.model.Computer;
import baseball.model.Judge;
import baseball.model.Player;
import baseball.view.OutputView;

public class GameController {

    private Player player;
    private Computer computer;
    private Judge judge;

    public void init() {
        createComputerAnswer();

        do {
            loadPlayerNumber();
        } while (!isGameSuccess());

        isGameRestartOrStop();
    }

    public void createComputerAnswer() {
        OutputView.printStart();
        computer = new Computer();
        computer.setRandomNumber();
    }
}