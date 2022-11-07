package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class User {
    boolean keepProgram = true;
    List<Integer> userNumberList;
    int userNumber;
    private final int NUMBER_LENGTH = Computer.NUMBER_LENGTH;
    private final int SMALLEST_NUMBER = (int) Math.pow(10, NUMBER_LENGTH - 1);
    private final int BIGGEST_NUMBER = (int) Math.pow(10, NUMBER_LENGTH);
    static final String CONTINUE_PROGRAM_NUMBER = "1";
    static final String END_PROGRAM_NUMBER = "2";

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
            List<Integer> numberList = numberToList(userNumber);
            Set<Integer> numberSet = new HashSet<>(numberList);

            checkNumberHasZero(numberList);
            checkNumberHasSameNumber(numberList, numberSet);
            return;
        }
        makeError();
    }

    private void checkNumberHasZero(List<Integer> numberList) {
        if (numberList.contains(0)) {
            makeError();
        }
    }

    private void checkNumberHasSameNumber(List<Integer> numberList, Set<Integer> numberSet) {
        if (numberList.size() != numberSet.size()) {
            makeError();
        }
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
        if (userInput.equals(CONTINUE_PROGRAM_NUMBER)) {
            keepProgram = true;
            return;
        } else if (userInput.equals(END_PROGRAM_NUMBER)) {
            keepProgram = false;
            return;
        }
        makeError();
    }
}
