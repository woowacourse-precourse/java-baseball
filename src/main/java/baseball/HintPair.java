package baseball;

public class HintPair {
    private int countBall;
    private int countStrike;

    HintPair() {
        this.countBall = 0;
        this.countStrike = 0;
    }

    public void increaseBall() {
        countBall++;
    }

    public void increaseStrike() {
        countStrike++;
    }

    public int getCountBall() {
        return countBall;
    }

    public int getCountStrike() {
        return countStrike;
    }
}
