package baseball.number.inputnumber;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputNumberParser {

    private static final int DIGITS_FOR_THIS_GAME = 3;

    public List<Integer> parseInputNumber(String inputValue) {
        validateInputValue(inputValue);
        return new InputNumber(inputValueToList(inputValue)).inputNumbers();
    }

    private List<Integer> inputValueToList(String inputValue) {
        return IntStream.range(0, DIGITS_FOR_THIS_GAME)
                .mapToObj(i -> Integer.parseInt(inputValue.substring(i, i + 1)))
                .collect(Collectors.toList());
    }

    private void validateInputValue(String inputValue) {
        validateLengthForGame(inputValue);
        validatePositiveNumber(inputValue);
        validateContainsZero(inputValue);
        validateDuplicate(inputValue);
    }

    private void validateLengthForGame(String inputValue) {
        int length = inputValue.length();

        if (length != DIGITS_FOR_THIS_GAME) {
            throw new IllegalArgumentException("세자리의 숫자를 입력해 주세요.");
        }
    }

    private void validatePositiveNumber(String inputValue) {
        if (inputValue.contains("-")) {
            throw new IllegalArgumentException("양수만 입력해 주세요.");
        }
    }

    private void validateContainsZero(String inputValue) {
        if (inputValue.contains("0")) {
            throw new IllegalArgumentException("0은 포함될 수 없습니다. 다시 입력해 주세요.");
        }
    }

    private void validateDuplicate(String inputValue) {
        long count = IntStream.range(0, DIGITS_FOR_THIS_GAME)
                .mapToObj(inputValue::charAt)
                .distinct()
                .count();

        if (count < DIGITS_FOR_THIS_GAME) {
            throw new IllegalArgumentException("중복 숫자는 입력할 수 없습니다.");
        }
    }
}
