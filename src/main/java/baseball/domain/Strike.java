package baseball.domain;

public class Strike {

    private static final int ALL_STRIKE = 3;

    private int count;

    public Strike(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void add() {
        this.count++;
    }

    public boolean isAllStrike() {
        return this.count == ALL_STRIKE;
    }
}
