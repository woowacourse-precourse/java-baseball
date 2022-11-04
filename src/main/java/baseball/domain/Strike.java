package baseball.domain;

public class Strike {

    private int strike;


    public Strike() {
        strike = 0;
    }


    public int strike() {
        return strike;
    }


    public void addStrike() {
        strike+=1;
    }

    public void clearStrike() {
        strike=0;
    }
}
