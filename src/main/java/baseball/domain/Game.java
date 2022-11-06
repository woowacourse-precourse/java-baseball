package baseball.domain;

public class Game {
    private int strike;
    private int ball;

    public Game() {
        this.strike = 0;
        this.ball = 0;
    }

    public Game(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public void addBall() {
        this.ball += 1;
    }

    public void addStrike() {
        this.strike += 1;
        this.ball -= 1;
    }
}
