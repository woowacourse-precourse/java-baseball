package baseball;

import java.util.ArrayList;
import java.util.List;

public class InputValidation {
    private static final int NUMBER_LENGTH = 3;
    private static final String RESTART_NUMBER = "1";
    private static final String EXIT_NUMBER = "2";

    public static void validateInputValue(String inputValue) {
        validateValueLength(inputValue);
        validateValueType(inputValue);
        validateIsDiffrentValue(inputValue);
        validateIsZero(inputValue);
    }

    private static void validateValueLength(String inputValue) {
        if (inputValue.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(NUMBER_LENGTH + "자리 숫자만 입력 가능합니다.");
        }
    }

    private static void validateValueType(String inputValue) {
        for (int i = 0; i < inputValue.length(); i++) {
            if (!Character.isDigit(inputValue.charAt(i))) {
                throw new IllegalArgumentException("숫자만 입력 가능합니다.");
            }
        }
    }

    private static void validateIsZero(String inputValue) {
        if (inputValue.contains("0")) {
            throw new IllegalArgumentException("1부터 9까지의 숫자만 입력 가능합니다.");
        }
    }

    private static void validateIsDiffrentValue(String inputNumber) {
        List<String> numList = new ArrayList<>(List.of(inputNumber.split("")));
        if (numList.size() != numList.stream().distinct().count()) {
            throw new IllegalArgumentException("서로 다른 숫자만 입력 가능합니다.");
        }
    }

    public static void validateIsOneOrTwo(String inputValue) {
        if (!inputValue.equals(RESTART_NUMBER) && !inputValue.equals(EXIT_NUMBER)) {
            throw new IllegalArgumentException(RESTART_NUMBER + " 또는 " + EXIT_NUMBER + "만 입력 가능합니다.");
        }
    }
}