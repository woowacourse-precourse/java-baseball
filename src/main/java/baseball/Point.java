package baseball;

class Point {
    private int strike;
    private int ball;

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public Point setBall(int ball) {
        this.ball = ball;
        return this;
    }

    public Point setStrike(int strike) {
        this.strike = strike;
        return this;
    }
}