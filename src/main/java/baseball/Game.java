package baseball;

import baseball.domain.Computer;
import baseball.domain.Gamer;
import baseball.domain.Hint;
import baseball.domain.Rule;

import static baseball.constant.Constant.*;
import static baseball.view.View.*;

public class Game {
    public Game() {
        printStartGame();
    }

    public void play() {
        Computer computer = new Computer();
        Gamer gamer = new Gamer();
        Rule rule = new Rule();
        Hint.init();

        while (Hint.getStrikeCount() != RANDOM_NUMBERS_LENGTH) {
            inputNumbers();
            rule.applyHint(gamer, computer);
            printHint();
        }

        printGameOver();
        if (rule.isReset(gamer)) {
            play();
        }
    }
}
