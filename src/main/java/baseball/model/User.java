package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static final int EXPECTED_NUMBER_OF_USER_LENGTH = 3;
    private List<Integer> expectedNumberOfUser;

    public User() {
        expectedNumberOfUser = new ArrayList<>();
    }

    public void setExpectedNumberOfUser(String expectedNumberOfUser) {
        this.expectedNumberOfUser.clear();

        for (int i = 0; i < EXPECTED_NUMBER_OF_USER_LENGTH; i++) {
            this.expectedNumberOfUser.add(expectedNumberOfUser.charAt(i) - '0');
        }
    }

    public List<Integer> getExpectedNumberOfUser() {
        return expectedNumberOfUser;
    }
}
