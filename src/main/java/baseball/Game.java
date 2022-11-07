package baseball;

import baseball.domain.Computer;
import baseball.domain.Gamer;
import baseball.domain.Hint;
import baseball.domain.Rule;

public class Game {
    private final Computer computer;
    private final  Gamer gamer;
    private Hint hint;
    private final Rule rule;

    public Game() {
        computer = new Computer();
        gamer = new Gamer();
        rule = new Rule();
    }
    public void play() {

    }
}
