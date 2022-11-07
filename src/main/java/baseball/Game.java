package baseball;

import baseball.domain.Computer;
import baseball.domain.Gamer;
import baseball.domain.Hint;
import baseball.domain.Rule;

import static baseball.constant.Constant.*;
import static baseball.view.View.*;

public class Game {
    private final Computer computer;
    private final Gamer gamer;
    private final Rule rule;

    public Game() {
        computer = new Computer();
        gamer = new Gamer();
        rule = new Rule();
    }

    public void play() {
        printStartGame();
        System.out.println(computer.getRandomNumbers());
        while (Hint.getStrikeCount() != RANDOM_NUMBERS_LENGTH) {
            inputNumbers();
            rule.getHint(gamer.inputNumbers(), computer.getRandomNumbers());
        }

        printGameOver();
        if(rule.isReset(gamer.inputReset())) {
            play();
        }
    }
}
