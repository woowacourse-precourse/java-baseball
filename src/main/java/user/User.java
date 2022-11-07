package user;

import java.util.List;

public class User {

    private List<Integer> tryNumber;

    public User(List<Integer> tryNumber) {
        this.tryNumber = tryNumber;
    }

    public List<Integer> getTryNumber() {
        return tryNumber;
    }

    public void tryCorrectNumber(List<Integer> tryNumber){
        this.tryNumber = tryNumber;
    }
}
