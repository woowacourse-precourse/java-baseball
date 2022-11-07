package baseball.domain;

public class Strike {

    private int count = 0;

    public Strike(int count) {
        this.count = count;
    }

    public void addCount() {
        this.count += 1;
    }

    public int getCount() {
        return count;
    }
}
