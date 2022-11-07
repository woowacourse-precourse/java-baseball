package baseball.domain;

import java.util.ArrayList;

public class User {
    ArrayList<Integer> userNumbers;

    public ArrayList<Integer> getUserNumbers() {
        return userNumbers;
    }

    public void setUserNumbers(String userInput) {
        ArrayList<Integer> userNumberList = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++) {
            userNumberList.add(userInput.charAt(i) - '0');
        }
        this.userNumbers = userNumberList;
    }
}
