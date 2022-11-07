package baseball.data;

import java.util.ArrayList;
import java.util.List;

public class UserNumber extends BaseballNumber {

    private static UserNumber userNumber;
    private List<Integer> numbers;

    private UserNumber() {
        numbers = new ArrayList<>();
    }

    public static UserNumber getInstance() {
        if(userNumber == null) {
            userNumber = new UserNumber();
        }

        return userNumber;
    }
}
