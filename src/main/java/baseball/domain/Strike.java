package baseball.domain;

public class Strike {

    private int strike = 0;


    public int strike() {
        return strike;
    }

    public void putStrike(int n) { strike = n; }
    public void clearStrike() {
        strike=0;
    }
}
