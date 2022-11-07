package baseball.domain;

import baseball.util.Validator;

public class Ball {

    private int count ;

    public Ball(int count) {
        Validator.validateBallCount(count);
        this.count = count;
    }

    public void addCount() {
        this.count += 1;
    }

    public int getCount() {
        return count;
    }
}
