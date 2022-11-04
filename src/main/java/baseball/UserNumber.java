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

    private final List<Integer> userNumbers;

    public UserNumber(String userNumbers) {
        this.userNumbers = validate(userNumbers);
    }

    private List<Integer> validate(String userNumbers) {
        String newUserNumbers = validateBlank(userNumbers);
        validateNumberCount(newUserNumbers);
        Integer newTypeUserNumbers = validateNumber(newUserNumbers);
        return validateDuplication(newTypeUserNumbers);
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

    private Integer validateNumber(String newUserNumber) {
        try {
            return Integer.parseInt(newUserNumber);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    private List<Integer> validateDuplication(Integer newTypeUserNumbers) {
        Set<Integer> numbers = new LinkedHashSet<>();
        while (newTypeUserNumbers > NUMBER_LENGTH_CRITERIA_ZERO) {
            numbers.add(newTypeUserNumbers % NUMBER_DIVIDE_CRITERIA_TEN);
            newTypeUserNumbers /= NUMBER_DIVIDE_CRITERIA_TEN;
        }
        if (numbers.size() != NUMBER_SIZE_CRITERIA_THREE) {
            throw new IllegalArgumentException("중복된 값이 있습니다.");
        }
        return new ArrayList<>(numbers);
    }

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }

}
