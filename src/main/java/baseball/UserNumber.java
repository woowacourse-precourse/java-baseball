package baseball;

import java.util.*;

public class UserNumber {

    private static final int INITIAL_REPEAT_VALUE = 0;
    private static final int DEFAULT_LENGTH_VALUE = 3;
    private static final String STRING_INITIAL_VALUE = "0";

    private final List<Integer> userNumbers;

    public UserNumber(String inputNumber) {
        this.userNumbers = generateUserNumber(inputNumber);
    }

    private List<Integer> generateUserNumber(String inputNumber) {
        validate(inputNumber);
        return modifyNumberType(divideNumber(inputNumber));
    }

    private void validate(String inputNumber) {
        validateLength(inputNumber.length());
        validateBlank(inputNumber);
    }

    private void validateLength(int number) {
        if (number < DEFAULT_LENGTH_VALUE) {
            throw new IllegalArgumentException("입력해야 할 숫자가 3개보다 작습니다.");
        }
        if (number > DEFAULT_LENGTH_VALUE) {
            throw new IllegalArgumentException("입력해야 할 숫자가 3개보다 많습니다.");
        }
    }

    private void validateBlank(String inputNumber) {
        if (inputNumber.contains(" ")) {
            throw new IllegalArgumentException("입력에 공백이 포함되어있습니다.");
        }
    }

    private List<String> divideNumber(String inputNumber) {
        Set<String> tempNumbers = new LinkedHashSet<>();
        for (int i = INITIAL_REPEAT_VALUE; i < inputNumber.length(); i++) {
            tempNumbers.add(String.valueOf(inputNumber.charAt(i)));
        }
        validateOverlap(tempNumbers);
        validateNumberRange(tempNumbers);
        return new ArrayList<>(tempNumbers);
    }

    private void validateOverlap(Set<String> inputNumber) {
        if (inputNumber.size() != DEFAULT_LENGTH_VALUE) {
            throw new IllegalArgumentException("중복 숫자가 포함되어있습니다.");
        }
    }

    private void validateNumberRange(Set<String> tempNumbers) {
        for (String number : tempNumbers)
            if (number.equals(STRING_INITIAL_VALUE)) {
                throw new IllegalArgumentException("입력한 숫자가 1~9 범위를 벗어났습니다.");
            }
    }

    private List<Integer> modifyNumberType(List<String> inputNumbers) {
        List<Integer> userNumbers = new ArrayList<>();
        for (String inputNumber : inputNumbers) {
            userNumbers.add(validateType(inputNumber));
        }
        return userNumbers;
    }

    private int validateType(String number) {
        try {
            return Integer.parseInt(number);
        } catch (IllegalArgumentException exceptionMessage) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }

}
