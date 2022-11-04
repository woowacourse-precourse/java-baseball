package baseball;

import java.util.ArrayList;
import java.util.List;


public class User {

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

    List<Integer> numberToList(int userNumber) {
        List<Integer> userNumberList = new ArrayList<>(3);
        for (int divideNumber = 100; divideNumber >= 1; divideNumber /= 10) {
            userNumberList.add(userNumber / divideNumber);
            userNumber -= (userNumber / divideNumber) * divideNumber;
        }
        return userNumberList;
    }
}
