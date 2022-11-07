package baseball;

public class GameInfo {
    private int ball;
    private int strike;

    public GameInfo() {
        ball = 0;
        strike = 0;
    }

    public void increaseBall() {
        ball++;
    }

    public void increaseStrike() {
        strike++;
    }
}
