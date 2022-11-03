package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserNumber {
    private final List<Integer> userNums;

    public UserNumber(String input) {
        this.userNums = convertInputStringToUserNums(input);
    }

    private List<Integer> convertInputStringToUserNums(String input) {
        List<Integer> userNums = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            userNums.add(Integer.valueOf(String.valueOf(input.charAt(0))));
        }
        return userNums;
    }

    public List<Integer> getUserNums() {
        return Collections.unmodifiableList(this.userNums);
    }
}
