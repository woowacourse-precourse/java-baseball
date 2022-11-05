package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;


public class User {
    boolean keepGame = true;
    List<Integer> userNumberList;
    int userNumber;
    User() {
    }

    void inputGameNumber() {
        userNumber = -1;

        String userInput = Console.readLine();
        if (checkType(userInput)) {
            userNumber = Integer.parseInt(userInput);
        }
        checkNumber();
    }

    private void makeError() {
        throw new IllegalArgumentException();
    }

    private void checkNumber() {
        if (100 <= userNumber & userNumber <= 999) {
            if (numberToList(userNumber).contains(0)) {
                makeError();
                return;
            }
            return;
        }
        makeError();
    }

    private boolean checkType(String userInput) {
        try {
            Integer.parseInt(userInput);
            return true;
        } catch (NumberFormatException e) {
            makeError();
        }
        return false;
    }

    List<Integer> numberToList(int userNumber) {
        userNumberList = new ArrayList<>(3);
        for (int divideNumber = 100; divideNumber >= 1; divideNumber /= 10) {
            userNumberList.add(userNumber / divideNumber);
            userNumber -= (userNumber / divideNumber) * divideNumber;
        }
        return userNumberList;
    }

    void inputEndNumber() {
        String userInput = Console.readLine();
        checkType(userInput);
        if (userInput.equals("1")) {
            keepGame = true;
            return;
        } else if (userInput.equals("2")) {
            keepGame = false;
            return;
        }
        makeError();
    }
}
