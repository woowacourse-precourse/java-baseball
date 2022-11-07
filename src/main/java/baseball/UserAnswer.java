package baseball;

import java.util.ArrayList;
import java.util.List;

public class UserAnswer {

    private List<Integer> userNumber;


    public List<Integer> getUserNumber() {
        return userNumber;
    }

    public void StringtoList(String userInput) {
        userNumber = new ArrayList<>();
        sizeCheck(userInput);
        numberCheck(userInput);
        duplicateCheck(userInput);
    }

    private void duplicateCheck(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            duplicate(Character.toString(userInput.charAt(i)));
        }
    }

    private void duplicate(String userInput) {
        Integer i = Integer.parseInt(userInput);
        if (userNumber.contains(i)) {
            throw new IllegalArgumentException();
        }
        userNumber.add(i);
    }

    private void sizeCheck(String userInput) {
        if (!(userInput.length() == ConstGame.SIZE)) {
            throw new IllegalArgumentException();
        }
    }

    private void numberCheck(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            isDigit(userInput.charAt(i));
        }
    }

    private void isDigit(char c) {
        if (!Character.isDigit(c)) {
            throw new IllegalArgumentException();
        }
    }
}
