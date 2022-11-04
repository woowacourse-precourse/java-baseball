package baseball;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class UserNumber {

    private static final int NUMBER_LENGTH_CRITERIA_ZERO = 0;
    private static final int NUMBER_DIVIDE_CRITERIA_TEN = 10;
    private static final int NUMBER_SIZE_CRITERIA_THREE = 3;
    private static final String REPLACE_CRITERIA = "";
    private static final String DELETE_CRITERIA = " ";

    private final List<Long> userNumbers;

    public UserNumber(String userNumbers) {
        this.userNumbers = validate(userNumbers);
    }

    private List<Long> validate(String userNumbers) {
        String newUserNumbers = validateBlank(userNumbers); // 앞뒤, 숫자사이 공백       // 숫자가 맞는지
        validateNumberCount(newUserNumbers); // 숫자가 개수가 맞는지
        Long newTypeUserNumbers = validateNumber(newUserNumbers); // 형변환
        return validateDuplication(newTypeUserNumbers); // 중복된 수가 있는지
    }

    private String validateBlank(String userNumbers) {
        String newUserNumbers = userNumbers.trim().replace(DELETE_CRITERIA, REPLACE_CRITERIA);
        if (newUserNumbers.length() == NUMBER_LENGTH_CRITERIA_ZERO) {
            throw new IllegalArgumentException("입력을 하지 않았습니다.");
        }
        return newUserNumbers;
    }

    private void validateNumberCount(String newUserNumber) {
        if (newUserNumber.length() != NUMBER_SIZE_CRITERIA_THREE) {
            throw new IllegalArgumentException("숫자의 갯수가 다릅니다.");
        }
    }

    private Long validateNumber(String newUserNumber) {
        try {
            return Long.parseLong(newUserNumber);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    private List<Long> validateDuplication(Long newTypeUserNumbers) {
        Set<Long> numbers = new LinkedHashSet<>();
        while (newTypeUserNumbers > NUMBER_LENGTH_CRITERIA_ZERO) {
            numbers.add(newTypeUserNumbers % NUMBER_DIVIDE_CRITERIA_TEN);
            newTypeUserNumbers /= NUMBER_DIVIDE_CRITERIA_TEN;
        }
        if (numbers.size() != NUMBER_SIZE_CRITERIA_THREE) {
            throw new IllegalArgumentException("중복된 값이 있습니다.");
        }
        return new ArrayList<>(numbers);
    }

    public List<Long> getUserNumbers() {
        return userNumbers;
    }

}
