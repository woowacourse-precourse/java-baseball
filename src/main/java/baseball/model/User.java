package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Integer> userNumber;

    public User(List<Integer> userNumber) {
        this.userNumber = new ArrayList<>(userNumber);
    }

}
