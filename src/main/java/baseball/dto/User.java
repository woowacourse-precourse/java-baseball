package baseball.dto;

import java.util.ArrayList;
import java.util.List;

public class User {
    List<Integer> usersNumber;

    public User() {
        this.usersNumber = new ArrayList<>();
    }
    public User(List<Integer> numberList) {
        this.usersNumber = numberList;
    }

    public void updateUsersNumber (List<Integer> numberList) {
        this.usersNumber = numberList;
    }

    public List<Integer> getUsersNumber () {
        return usersNumber;
    }
}
