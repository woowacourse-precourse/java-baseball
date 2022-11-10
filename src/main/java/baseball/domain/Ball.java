package baseball.domain;

public class Ball {

    private int ball = 0;

    public int ball() {
        return ball;
    }

    public void putBall(int n) {ball = n;}

    public void clearBall() {
        ball = 0;
    }
}
