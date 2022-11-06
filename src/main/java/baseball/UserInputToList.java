package baseball;

import java.util.ArrayList;
import java.util.List;

public class UserInputToList {
    private List<Integer> userNum;

    public UserInputToList() {
        userNum = new ArrayList<>(3);
    }

    public void userNumList(String answer) {
        for (int i = 0; i < answer.length(); i++) {
            int n = answer.charAt(i) - 48;
            userNum.add(i, n);
        }
    }

    public List<Integer> getUserNum() {
        return userNum;
    }
}
