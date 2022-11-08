package domain;

public class Game {

    int[] computerNumber;
    int strike;
    int ball;

    public Game(int[] computerNumber) {
        this.computerNumber = computerNumber;
    }

    public int[] getComputerNumber() {
        return computerNumber;
    }
    public void initStrike() {
        strike = 0;
    }

    public void initBall() {
        ball = 0;
    }

    public void increaseStrike() {
        strike += 1;
    }

    public void increaseBall() {
        ball += 1;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
