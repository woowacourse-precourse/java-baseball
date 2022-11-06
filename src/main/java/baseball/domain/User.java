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

    public boolean isValid(List<Integer> userNum) {
        if (userNum.size() != 3) {
            return false;
        }
        if (userNum.size() != userNum.stream().distinct().count()) {
            return false;
        }
        for (int num : userNum) {
            if (num < 1 || num > 9) {
                return false;
            }
        }
        return true;
    }

}
