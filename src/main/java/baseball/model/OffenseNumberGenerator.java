package baseball.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class OffenseNumberGenerator {
    private static final int OFFENSE_NUMBER_SIZE = 3;
    private static final String NOT_ONLY_NUMBER_ERROR_MESSAGE = "공격 값이 유효한 숫자로만 이루어지지 않았습니다.";
    private static final String NOT_DISTINCT_ERROR_MESSAGE = "공격 값이 서로 다른 숫자가 아닙니다.";
    private static final String SIZE_ERROR_MESSAGE = "공격 값의 길이가 3이 아닙니다.";

    private OffenseNumberGenerator() {
    }

    public static OffenseNumberGenerator getInstance() {
        return new OffenseNumberGenerator();
    }

    public List<Integer> generateOffenseNumbers(String input) {
        validateOffenseNumbersInput(input);

        List<Integer> offenseNumbers = convertStringToIntegerList(input);
        return offenseNumbers;
    }

    private void validateOffenseNumbersInput(String input) {
        validateOnlyThreeNumbers(input);
        validateOnlyNumber(input);
        validateDistinctNumber(input);
    }

    private void validateOnlyThreeNumbers(String input) {
        if (input.length() != OFFENSE_NUMBER_SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    private void validateOnlyNumber(String input) {
        String pattern = "^[1-9]*$";
        if (!input.matches(pattern)) {
            throw new IllegalArgumentException(NOT_ONLY_NUMBER_ERROR_MESSAGE);
        }
    }

    private void validateDistinctNumber(String input) {
        String[] split = input.split("");
        int distinctNumberCount = (int) Arrays.stream(split).distinct().count();
        if (distinctNumberCount != OFFENSE_NUMBER_SIZE) {
            throw new IllegalArgumentException(NOT_DISTINCT_ERROR_MESSAGE);
        }
    }

    private List<Integer> convertStringToIntegerList(String input) {
        String[] inputToArray = input.split("");
        return Arrays.stream(inputToArray)
                .map(Integer::parseInt)
                .collect(Collectors.toUnmodifiableList());
    }
}
