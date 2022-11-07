package baseball;

import java.util.List;

public class UserBallNumber {
    private final List<Integer> userBallNumber;

    public UserBallNumber(List<Integer> userBallNumber){
        this.userBallNumber = userBallNumber;
    }

    public List<Integer> getUserBallNumber() {
        return userBallNumber;
    }
}
