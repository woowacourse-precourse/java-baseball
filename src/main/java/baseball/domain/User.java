package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Integer> userNumbers = new ArrayList<>();

    public List<Integer> getUserGameNumbers() {
        return userNumbers;
    }

    public void setUserGameNumbers(List<Integer> userNumbers) {
        this.userNumbers = userNumbers;
    }
}