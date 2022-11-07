package baseball.domain;

public class Number {
    private int strike;
    private int ball;

    public Number() {
        this.strike = 0;
        this.ball = 0;
    }

    public Number(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public void hitStrike() {
        this.strike++;
    }

    public void hitBall() {
        this.ball++;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isNothing() {
        if (strike == 0 && ball == 0) {
            return true;
        }
        return false;
    }

    public boolean isCorrect() {
        if (strike == 3) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number number = (Number) o;
        return strike == number.strike && ball == number.ball;
    }

    @Override
    public String toString() {
        return "Number{" +
                "strike=" + strike +
                ", ball=" + ball +
                '}';
    }

}
