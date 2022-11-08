package baseball.domain;

public class Referee {

    private int ball;
    private int strike;
    private static final int RESET_TO_ZERO = 0;

    public void initBallAndStrike(){
        ball = RESET_TO_ZERO;
        strike = RESET_TO_ZERO;
    }
}
