package baseball;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final static int NUMBER_LENGTH = 3;

    private List<Integer> userNumber = new ArrayList<>();

    public List<Integer> getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userInput) {
        for (int digit = 0; digit < NUMBER_LENGTH; digit++) {
            userNumber.add(Character.getNumericValue(userInput.charAt(digit)));
        }
    }
}
