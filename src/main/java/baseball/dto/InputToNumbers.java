package baseball.dto;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputToNumbers {

    private static final String NUMBER_PATTERN = "^[1-999]*$";

    public static List<Integer> toNumbers(String userNumbersInput) {
        validateNumberIsEmpty(userNumbersInput);
        validateUserNumberInputType(userNumbersInput);
        String[] userNumbers = userNumbersInput.split("");
        return Arrays.asList(userNumbers)
            .stream()
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    private static void validateUserNumberInputType(String userNumberInput) {
        if (!Pattern.matches(NUMBER_PATTERN, userNumberInput)) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private static void validateNumberIsEmpty(String userNumberInput) {
        if (userNumberInput.isBlank()) {
            throw new IllegalArgumentException("입력값이 없습니다");
        }
    }

}
