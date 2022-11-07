package user;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Integer> tryNumber;

    public User() {
        this.tryNumber = new ArrayList<>();
    }

    public List<Integer> getTryNumber() {
        return tryNumber;
    }

    public void tryCorrectNumber(List<Integer> tryNumber){
        this.tryNumber = tryNumber;
    }
}
