package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String input;
    private List<Integer> userNumbers;

    public void initializeUserNumbers() {
        userNumbers = new ArrayList<>();
    }

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }
}
