package baseball.domain;

public class Ball {

    private static final int ZERO = 0;

    private int count;

    public Ball(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void add() {
        this.count++;
    }

    public boolean isZERO() {
        return this.count == ZERO;
    }
}
