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

    // increaseBall(int n)
    // increaseStrike(int n)
}
