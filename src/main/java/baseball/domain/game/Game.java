package baseball.domain.game;

import baseball.domain.computer.Computer;
import baseball.domain.view.OutputView;

public class Game {
    public Game() {
        OutputView.startView();
        String numbers = Computer.getRandomNumbers();
        System.out.println("numbers = " + numbers);
    }
}