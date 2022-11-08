package baseball.components;

public class Score {

    private final int strike;
    private final int ball;

    public Score(int ball, int strike){
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
