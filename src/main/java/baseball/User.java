package baseball;

import java.util.List;

public class User {
    private final List numberList;

    public User(List numberList) {
        this.numberList = numberList;
    }

    public List getNumberList() {
        return numberList;
    }
}
