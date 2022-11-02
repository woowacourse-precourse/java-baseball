package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static final int INPUT_NUMBER_SIZE = 3;
    private List<Integer> userInputNumber;

    User() {
        userInputNumber = new ArrayList<>();
    }

    public void setUserInputNumber(String inputNumber) {
        userInputNumber.clear();

        for (int i = 0; i < INPUT_NUMBER_SIZE; i++) {
            userInputNumber.add(inputNumber.charAt(i) - '0');
        }
    }

    public List<Integer> getUserInputNumber() {
        return userInputNumber;
    }
}
