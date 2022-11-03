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

    private void validateCompareLetter(String userNumber) {
        try {
            Long.parseLong(userNumber);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    private void validateCheckEmpty(String userNumber) {
        if (userNumber.length() == NUMBER_SIZE_ZERO) {
            throw new IllegalArgumentException("압력을 하지 않았습니다.");
        }
    }

    private void validateCheckVacuum(String userNumber) {
        if (userNumber.contains(" ")) {
            throw new IllegalArgumentException("공백을 제거하고 입력해 주세요.");
        }
    }

}
