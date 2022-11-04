package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class User {
    List<Integer> computerNumberList;
    static boolean keepGame = true;

    User() {

    }

    User(List<Integer> computerNumberList) {
        this.computerNumberList = computerNumberList;
    }

    int inputNumber() {
        int userNumber = -1;

        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        if (checkType(userInput)) {
            userNumber = Integer.parseInt(userInput);
        }
        return userNumber;
    }

    void errorControl() {
        try {
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {

            System.out.println("프로그램을 종료합니다");
        }
    }

    boolean checkNumber(int userNumber) {
        if (100 <= userNumber & userNumber <= 999) {
            if (numberToList(userNumber).contains(0)) {
                errorControl();
                return false;
            }
            return true;
        }
        errorControl();
        return false;
    }

    boolean checkType(String userNumber) {
        try {
            Integer.parseInt(userNumber);
            return true;
        } catch (NumberFormatException e) {
            errorControl();
        }
        return false;
    }

    List<Integer> numberToList(int userNumber) {
        List<Integer> userNumberList = new ArrayList<>(3);
        for (int divideNumber = 100; divideNumber >= 1; divideNumber /= 10) {
            userNumberList.add(userNumber / divideNumber);
            userNumber -= (userNumber / divideNumber) * divideNumber;
        }
        return userNumberList;
    }

    int checkStrike(List<Integer> computerNumberList, List<Integer> userNumberList) {
        int strike = 0;
        for (int index = 0; index < 3; index++) {
            if (Objects.equals(computerNumberList.get(index), userNumberList.get(index))) {
                strike++;
            }
        }
        return strike;
    }
}
