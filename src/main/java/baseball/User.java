package baseball;

import java.util.ArrayList;
import java.util.List;

public class User {
    List<Integer> numberToList(int userNumber) {
        List<Integer> userNumberList = new ArrayList<>(3);
        for (int divideNumber = 100; divideNumber >= 1; divideNumber /= 10) {
            userNumberList.add(userNumber / divideNumber);
            userNumber -= (userNumber / divideNumber) * divideNumber;
        }
        return userNumberList;
    }
}
