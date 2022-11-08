package baseball;

import java.util.*;

import static baseball.ComputerRandomNumbersFactory.*;

public class UserNumber {

    private static final int NUMBER_LENGTH_CRITERIA_ZERO = 0;
    private static final int NUMBER_DIVIDE_CRITERIA_TEN = 10;
    private static final String USER_NUMBER_SPACE = " ";

    private final List<Integer> userNumbers;

    public UserNumber(String userNumbers) {
        this.userNumbers = validate(userNumbers);
    }

    private List<Integer> validate(String userNumbers) {
        validateEmpty(userNumbers);
        validateBlank(userNumbers);
        validateNumberCount(userNumbers);
        Integer newTypeUserNumbers = validateNumber(userNumbers);
        return validateOverlap(newTypeUserNumbers);
    }

    private void validateEmpty(String userNumbers) {
        if (userNumbers.length() == NUMBER_LENGTH_CRITERIA_ZERO) {
            throw new IllegalArgumentException("입력을 하지 않았습니다.");
        }
    }

    private void validateBlank(String userNumbers) {
        if (userNumbers.contains(USER_NUMBER_SPACE)) {
            throw new IllegalArgumentException("입력 값의 공백이 포함 되어있습니다.");
        }
    }

    private void validateNumberCount(String newUserNumber) {
        if (newUserNumber.length() != NUMBER_MAX_LENGTH) {
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

    private List<Integer> validateOverlap(Integer newTypeUserNumbers) {
        Set<Integer> deduplication = separate(newTypeUserNumbers);
        if (deduplication.size() != NUMBER_MAX_LENGTH) {
            throw new IllegalArgumentException("중복된 값이 있습니다.");
        }
        List<Integer> numbers = new ArrayList<>(deduplication);
        Collections.reverse(numbers);
        return numbers;
    }

    private Set<Integer> separate(Integer newTypeUserNumbers) {
        Set<Integer> deduplication = new LinkedHashSet<>();
        while (newTypeUserNumbers > NUMBER_LENGTH_CRITERIA_ZERO) {
            int newTypeUserNumber = newTypeUserNumbers % NUMBER_DIVIDE_CRITERIA_TEN;
            validateNumberRange(newTypeUserNumber);
            deduplication.add(newTypeUserNumber);
            newTypeUserNumbers /= NUMBER_DIVIDE_CRITERIA_TEN;
        }
        return deduplication;
    }

    private void validateNumberRange(Integer newTypeUserNumber) {
        if (newTypeUserNumber > MAX_NUMBER || newTypeUserNumber < MIN_NUMBER) {
            throw new IllegalArgumentException("숫자 범위가 벗어났습니다.");
        }
    }

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }

}
