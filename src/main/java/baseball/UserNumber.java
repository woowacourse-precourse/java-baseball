package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserNumber {
    private final List<Integer> userNums;

    public UserNumber(String userNumberInString) {
        Exceptions.isValidInputUserNums(userNumberInString);
        this.userNums = convertUserNumbers(userNumberInString);
    }

    public static List<Integer> convertUserNumbers(String userNumberInString) {
        List<Integer> userNums = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String eachNumber = String.valueOf(userNumberInString.charAt(i));
            Integer convertedUserNumber = Integer.valueOf(eachNumber);
            userNums.add(convertedUserNumber);
        }
        return userNums;
    }

    public List<Integer> getUserNums() {
        return Collections.unmodifiableList(this.userNums);
    }
}
