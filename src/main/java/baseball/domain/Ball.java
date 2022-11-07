package baseball.domain;

public class Ball {

    private int count ;

    public Ball(int count) {
        this.count = count;
    }

    public void addCount() {
        this.count += 1;
    }

    public int getCount() {
        return count;
    }
}
