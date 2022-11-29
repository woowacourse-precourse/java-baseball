package baseball.controller;

import baseball.model.Computer;
import baseball.model.Number;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        outputView.printGameStart();
        Number number = new Number();

        Computer computer = Computer.createComputerByNumber(number.getRandomNumbers());
        System.out.println(computer.getComputerNumber());
    }


}
