package baseball.domain.game;

import baseball.domain.computer.Computer;
import baseball.domain.view.InputView;
import baseball.domain.view.OutputView;

public class Game {
    public Game() {
        OutputView.startView();
        String randomNumbers = Computer.getRandomNumbers();
        String inputNumbers = InputView.printNumbers();
    }
}