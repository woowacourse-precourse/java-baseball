package baseball.domain;

import baseball.view.View;

import static baseball.constant.Constants.*;

public class Game {
    private final Computer computer;
    private final Player player;

    public Game() {
        computer = new Computer();
        player = new Player();
    }

    public void start() {
        View.printGameStart();
        do {
            computer.generateNumber();
            guessAndCheck();
            View.printGameClear();
        } while (player.getChoice() == RESTART_CHOICE);
        View.printGameFinished();
    }

    public void guessAndCheck() {
        Result result;
        do {
            View.printInputGuide();
            String guessNumber = player.getInput();
            result = computer.compareNumber(guessNumber);
            View.printResult(result);
        } while (result.isNotOver());
    }
}
