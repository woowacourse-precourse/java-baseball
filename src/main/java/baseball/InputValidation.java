package baseball;

import java.util.ArrayList;
import java.util.List;

public class InputValidation {
    private final int NUMBER_LENGTH = 3;
    private final String RESTART_NUMBER = "1";
    private final String EXIT_NUMBER = "2";

    public void validateInputValue(String inputValue) {
        validateValueLength(inputValue);
        validateValueType(inputValue);
        validateIsDifferentValue(inputValue);
        validateIsZero(inputValue);
    }

    private void validateValueLength(String inputValue) {
        if (inputValue.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(NUMBER_LENGTH + "자리 숫자만 입력 가능합니다.");
        }
    }

    private void validateValueType(String inputValue) {
        for (int i = 0; i < inputValue.length(); i++) {
            if (!Character.isDigit(inputValue.charAt(i))) {
                throw new IllegalArgumentException("숫자만 입력 가능합니다.");
            }
        }
    }

    private void validateIsZero(String inputValue) {
        if (inputValue.contains("0")) {
            throw new IllegalArgumentException("1부터 9까지의 숫자만 입력 가능합니다.");
        }
    }

    private void validateIsDifferentValue(String inputNumber) {
        List<String> numList = new ArrayList<>(List.of(inputNumber.split("")));
        if (numList.size() != numList.stream().distinct().count()) {
            throw new IllegalArgumentException("서로 다른 숫자만 입력 가능합니다.");
        }
    }

    public void validateIsOneOrTwo(String inputValue) {
        if (!inputValue.equals(RESTART_NUMBER) && !inputValue.equals(EXIT_NUMBER)) {
            throw new IllegalArgumentException(RESTART_NUMBER + " 또는 " + EXIT_NUMBER + "만 입력 가능합니다.");
        }
    }
}