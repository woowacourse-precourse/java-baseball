package baseball.core;

public class Count {
    private int ball;
    private int strike;

    public Count() {
        this.setBall(0);
        this.setStrike(0);
    }

    public int getBall() {
        return ball;
    }

    public Count setBall(int ball) {
        this.ball = ball;
        return this;
    }

    public void addBall() {
        this.ball += 1;
    }

    public int getStrike() {
        return strike;
    }

    public Count setStrike(int strike) {
        this.strike = strike;
        return this;
    }

    public void addStrike() {
        this.strike += 1;
    }

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder();
        if (this.ball > 0) {
            returnString.append(this.ball + "볼 ");
        }
        if (this.strike > 0) {
            returnString.append(this.strike + "스트라이크");
        }
        if (returnString.length() == 0) {
            returnString.append("낫싱");
        }
        return returnString.toString().strip();
    }
}
