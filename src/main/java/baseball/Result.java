package baseball;

public class Result {

    private ResultType resultType;

    private int ball = 0;
    private int strike = 0;

    public void increaseStrike() {
        strike++;
    }

    public void increaseBall() {
        ball++;
    }
}
