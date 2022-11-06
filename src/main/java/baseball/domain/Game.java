package baseball.domain;

public class Game {
    private int LENGTH = 3;
    private Computer computer;

    public Game() {
        computer = new Computer(LENGTH);
    }

    public void start() {
        int strike = 0;
        int ball = 0;
    }
}
