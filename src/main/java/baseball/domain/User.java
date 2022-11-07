package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    List<Integer> userNumbers = new ArrayList<>();

    public void setUserNumbers(List<Integer> userNumbers) {
        this.userNumbers = userNumbers;
    }

    public List<Integer> getUserNumbers() {
        return this.userNumbers;
    }

}
