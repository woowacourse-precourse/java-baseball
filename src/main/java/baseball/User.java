package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {

    private static final int NUMBER_SIZE_ZERO = 0;
    private static final int NUMBER_SIZE_ONE = 1;
    private static final int NUMBER_SIZE_THREE = 3;

    private final List<Long> userNumbers;

    public User(String userNumber) {
        this.userNumbers = validateReprocessingCheckUserNumber(userNumber);
    }

    private List<Long> validateReprocessingCheckUserNumber(String userNumber) {
        validateCompareLetter(userNumber);
        validateCheckEmpty(userNumber);
        validateCheckVacuum(userNumber);
        validateTheNumber(userNumber);
        validateCheckOverlapping(userNumber);
        return reprocessingUserNumber(userNumber);
    }

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
            throw new IllegalArgumentException("숫자가 아닙니다. 숫자만 입력해 주세요.");
        }
    }

    private void validateCheckEmpty(String userNumber) {
        if (userNumber.length() == NUMBER_SIZE_ZERO) {
            throw new IllegalArgumentException("압력을 하지 않았습니다.");
        }
    }

    private void validateCheckVacuum(String userNumber) {
        if (userNumber.contains(" ")) {
            throw new IllegalArgumentException("공백을 제외하고 입력해 주세요.");
        }
    }

    private void validateTheNumber(String userNumber) {
        if (userNumber.length() != NUMBER_SIZE_THREE) {
            throw new IllegalArgumentException("3개의 숫자만 입력해 주세요.");
        }
    }

    private void validateCheckOverlapping(String userNumber) {
        Set<Long> userNumbers = new HashSet<>(reprocessingUserNumber(userNumber));
        if (userNumbers.size() < NUMBER_SIZE_THREE) {
            throw new IllegalArgumentException("중복된 값이 있습니다.");
        }
    }

    public List<Long> getUserNumbers() {
        return userNumbers;
    }

}
