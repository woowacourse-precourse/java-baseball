package baseball.domain.game;

import baseball.domain.computer.Computer;
import baseball.domain.validate.NumberVerifier;
import baseball.domain.view.InputView;
import baseball.domain.view.OutputView;

public class Game {
    public Game() {
        OutputView.printStart();
        String randomNumbers = Computer.getRandomNumbers();
        while (true) {
            String inputNumbers = InputView.printNumbers();
            if (NumberVerifier.numberVerifier(randomNumbers, inputNumbers)) {
                break;
            }
        }
        OutputView.printEnd();
    }
}