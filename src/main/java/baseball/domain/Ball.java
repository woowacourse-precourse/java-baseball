package baseball.domain;

public class Ball {

    private int ball;


    public Ball() {
        ball = 0;
    }


    public int ball() {
        return ball;
    }


    public void addBall() {
        ball+=1;
    }

    public void clearBall() {
        ball = 0;
    }
}
