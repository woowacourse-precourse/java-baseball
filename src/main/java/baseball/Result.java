package baseball;

public class Result {
    private int ball;
    private int strike;

    Result() {
        ball = 0;
        strike = 0;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public void addBall() {
        ball++;
    }

    public void addStrike() {
        strike++;
    }

    public String ballToString() {
        if (ball == 0) {
            return null;
        }
        return ball + "볼";
    }

    public String strikeToString() {
        if (strike == 0) {
            return null;
        }
        return strike + "스트라이크";
    }

    @Override
    public String toString() {
        if (ballToString() == null && strikeToString() == null) {
            return "낫싱";
        }
        if (ballToString() == null) {
            return strikeToString();
        }
        if (strikeToString() == null) {
            return ballToString();
        }
        return ballToString() + " " + strikeToString();
    }
}
