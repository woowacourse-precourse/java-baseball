package baseball;

import java.util.*;

public class UserNumber {

    private static final int NUMBER_MIN_VALUE = 1;
    private static final int NUMBER_MAX_VALUE = 9;
    private static final int INITIAL_REPEAT_VALUE = 0;
    private static final int DEFAULT_LENGTH_VALUE = 3;

    private final List<Integer> userNumbers;

    public UserNumber(List<Integer> userNumbers) {
        this.userNumbers = userNumbers;
    }

    public void generateUserNumber(String inputNumber) {
        validate(inputNumber);
        changeNumberType(divideNumber(inputNumber));
    }

    private List<String> divideNumber(String inputNumber) {
        List<String> tempNumbers = new ArrayList<>();
        for (int i = INITIAL_REPEAT_VALUE; i < inputNumber.length(); i++) {
            tempNumbers.add(String.valueOf(inputNumber.charAt(i)));
        }
        return tempNumbers;
    }

    private void changeNumberType(List<String> inputNumbers) {
        for (String inputNumber : inputNumbers) {
            validateType(inputNumber);
            userNumbers.add(Integer.valueOf(inputNumber));
        }
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
            throw new IllegalArgumentException("입력해야 할 숫자가 3개보다 큽니다.");
        }
    }

    private void validateBlank(String inputNumber) {
        if (inputNumber.contains(" ")) {
            throw new IllegalArgumentException("공백이 포함되어있습니다.");
        }
    }

    private void validateType(String number) {
        if (Integer.parseInt(number) / NUMBER_MIN_VALUE < INITIAL_REPEAT_VALUE
                || Integer.parseInt(number) / NUMBER_MIN_VALUE > NUMBER_MAX_VALUE) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }

}
