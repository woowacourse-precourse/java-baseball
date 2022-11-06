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

        while(!isComplete(strike)) {

        }
    }

    private boolean isComplete(int strike) {
        if(LENGTH == strike) return true;
        else return false;
    }
}
