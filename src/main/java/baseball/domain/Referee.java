package baseball.domain;

import baseball.infrastructure.util.ConsoleInStringImpl;

public class Referee {

    private Computer computer;
    private Gamer gamer;

    public Referee() {
        ConsoleInString consoleInString = new ConsoleInStringImpl();
        this.computer = Computer.init();
        this.gamer = Gamer.from(consoleInString);
    }

    public static Referee getInstance() {
        return new Referee();
    }
}
