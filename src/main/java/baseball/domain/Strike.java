package baseball.domain;

import baseball.util.Validator;

public class Strike {

    private int count ;

    public Strike(int count) {
        Validator.validateStrikeCount(count);
        this.count = count;
    }

    public void addCount() {
        this.count += 1;
    }

    public int getCount() {
        return count;
    }
}
