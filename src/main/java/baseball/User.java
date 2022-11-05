package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;


public class User {
    boolean keepProgram = true;
    List<Integer> userNumberList;
    int userNumber;
    final int NUMBER_LENGTH = Computer.NUMBER_LENGTH;
    final int SMALLEST_NUMBER = (int) Math.pow(10, NUMBER_LENGTH - 1);
    final int BIGGEST_NUMBER = (int) Math.pow(10, NUMBER_LENGTH);

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
        if (SMALLEST_NUMBER <= userNumber & userNumber < BIGGEST_NUMBER) {

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
        userNumberList = new ArrayList<>(NUMBER_LENGTH);
        for (int divideNumber = SMALLEST_NUMBER; divideNumber >= 1; divideNumber /= 10) {
            userNumberList.add(userNumber / divideNumber);
            userNumber -= (userNumber / divideNumber) * divideNumber;
        }
        return userNumberList;
    }

    void inputEndNumber() {
        String userInput = Console.readLine();
        checkType(userInput);
        if (userInput.equals("1")) {
            keepProgram = true;
            return;
        } else if (userInput.equals("2")) {
            keepProgram = false;
            return;
        }
        makeError();
    }
}
