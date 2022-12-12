package baseball.model;

import java.util.List;

public class User {

    private Numbers userBaseballNumbers;

    public User() {}

    public void updateNumbers(int inputNumbers) {
        this.userBaseballNumbers = Numbers.createNumbers(inputNumbers);
    }

    public BaseballNumber findUserNumber(int index) {
        return userBaseballNumbers.findNumber(index);
    }
}
