package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final List<Integer> user;

    public User() {
        user = new ArrayList<>();
    }

    public Integer stringToInteger(String input){
        return Integer.parseInt(input);
    }

}
