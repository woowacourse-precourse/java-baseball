package baseball.entity;

public class Score {

    private int ball = 0;
    private int strike = 0;

    public void increaseBall(int ballCnt) {
        ball += ballCnt;
    }

    public void increaseStrike(int strikeCnt) {
        strike += strikeCnt;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
