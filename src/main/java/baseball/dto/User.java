package baseball.dto;

import java.util.List;

public class User {
    List<Integer> usersNumber;

    public User(List<Integer> numberList) {
        this.usersNumber = numberList;
    }

    public List<Integer> getUsersNumber () {
        return usersNumber;
    }
}
