package baseball;

public class Result {
    int strike;
    int ball;

    public void plusStrike(){
        strike++;
    }

    public void plusBall(){
        ball++;
    }

    public int getStrike(){
        return strike;
    }

    public int getBall(){
        return ball;
    }

    public void initBallAndStrike(){
        strike=0;
        ball=0;
    }
}
