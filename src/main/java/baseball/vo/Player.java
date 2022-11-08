package baseball.vo;

import java.util.List;

public class Player {
    private final List<Integer> userSelectNumbers;

    public Player(List<Integer> userSelectNumbers) {
        this.userSelectNumbers = userSelectNumbers;
    }

    public List<Integer> getUserSelectNumbers() {
        return userSelectNumbers;
    }
}
