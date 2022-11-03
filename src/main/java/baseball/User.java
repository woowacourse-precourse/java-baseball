package baseball;

import java.util.ArrayList;
import java.util.List;

public class User {

    private static final int NUMBER_SIZE_ZERO = 0;
    private static final int NUMBER_SIZE_ONE = 1;

    private List<Long> reprocessingUserNumber(String userNumber) {
        List<Long> userNumbers = new ArrayList<>();
        for (int i = NUMBER_SIZE_ZERO; i < userNumber.length(); i++) {
            userNumbers.add(Long.parseLong(userNumber.substring(i, i + NUMBER_SIZE_ONE)));
        }
        return userNumbers;
    }
}
