package baseball;

public class Ball {
    private static final int END = 3;

    private int strike;
    private int ball;

    public Ball(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void addStrike() {
        strike += 1;
    }

    public void addBall() {
        ball += 1;
    }

    public boolean isEnd() {
        return strike == END;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        if (isNothing()) {
            return "낫싱";
        }
        appendBall(string);
        return string.toString();
    }

    private void appendBall(StringBuilder string) {
        if (ball != 0){
            string.append(ball + "볼 ");
        }
        if (strike != 0) {
            string.append(strike + "스트라이크");
        }
    }

    private boolean isNothing() {
        return (strike + ball) == 0;
    }
}
