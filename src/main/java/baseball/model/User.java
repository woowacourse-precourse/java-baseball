package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static final int NUMBER_LENGTH = 3;
    private List<Integer> userData;

    public User() {
        initData();
    }

    public void editNumberString(String number) {
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            this.userData.add(Character.getNumericValue(number.charAt(i)));
        }
    }

    public void initData() {
        this.userData = new ArrayList<Integer>();
    }

    public List<Integer> getUserData() {
        return userData;
    }
}
