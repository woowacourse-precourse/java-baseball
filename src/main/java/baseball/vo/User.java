package baseball.vo;

import java.util.List;

public class User {

    private final List<Integer> userNumbers;

    public User(List<Integer> userNumbers) {
        this.userNumbers = userNumbers;
    }

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }

}
