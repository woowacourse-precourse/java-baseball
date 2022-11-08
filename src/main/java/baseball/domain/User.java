package baseball.domain;

import java.util.List;

public class User {
    private static List<Integer> userNumbers;

    public static List<Integer> getUserNumbers() {
        return userNumbers;
    }

    public static void setUserNumbers(List<Integer> userNumbers) {
        User.userNumbers = userNumbers;
    }
}
