package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class UserBaseballNumber {
    private static List<Integer> userNumber;

    public UserBaseballNumber(String baseballNumber) {
        this.userNumber = userBaseballNumber(baseballNumber);
    }

    public List<Integer> userBaseballNumber(String baseballNumber) {
        List<Integer> userNumberList = new ArrayList<>();
        for (int i = 0; i < baseballNumber.length(); i++) {
            userNumberList.add(baseballNumber.charAt(i)-'0');
        }
        return userNumberList;
    }

    public List<Integer> getUserNumber() {
        return userNumber;
    }
}
