package baseball.domain.baseballAlgorithm;

public enum BallAndStrike {
    ball(0),
    strike(0);

    private int count;

    BallAndStrike(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
