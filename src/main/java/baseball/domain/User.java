package baseball.domain;

import java.util.List;

public class User {
    private List<Integer> userNum;

    public User() {
    }

    public List<Integer> getUserNum() {
        return userNum;
    }

    public void setUserNum(List<Integer> userNum) {
        this.userNum = userNum;
    }

    public boolean isValid(List<Integer> userNum, Game game) {
        if (userNum.size() != game.getDigit()) {
            return false;
        }
        if (userNum.size() != userNum.stream().distinct().count()) {
            return false;
        }
        for (int num : userNum) {
            if (num < game.getStartRange() || num > game.getEndRange()) {
                return false;
            }
        }
        return true;
    }

}
