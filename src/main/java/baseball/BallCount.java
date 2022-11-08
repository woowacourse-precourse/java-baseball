package baseball;

public class BallCount {
    private int strike;
    private int ball;

    public BallCount() {
        //start status ballCount 0 - 0
        initCount();
    }

    // <Func> : Initialize ball count
    public void initCount() {
        strike = 0;
        ball = 0;
    }

    // <Func> : Add strike
    public void strikeUp() {
        strike += 1;
    }

    // <Func> : Add ball
    public void ballUp() {
        ball += 1;
    }

    // GETTER, SETTER
    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

}
