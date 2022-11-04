package baseball.domain;

import baseball.infrastructure.util.ConsoleInStringImpl;

public class Referee {

    private Computer computer;
    private Gamer gamer;

    public Referee() {
        ConsoleInString consoleInString = new ConsoleInStringImpl();
        this.computer = Computer.init();
        this.gamer = Gamer.from(consoleInString);
        matchBalls();
    }

    public static Referee initGame() {
        return new Referee();
    }

    public GameReport matchBalls() {
        Balls computerBalls = computer.currentComputerBalls();
        Balls gamerBalls = gamer.currentGamerBalls();
        return computerBalls.ballsMatch(gamerBalls);
    }
}
