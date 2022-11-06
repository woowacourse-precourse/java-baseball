package baseball.domain.inputnumber;

import baseball.domain.SingleNumber;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputNumberFactory {

    public static InputNumbers newInstance(String inputValue) {
        validateLengthForGame(inputValue);
        validateDuplicate(inputValue);
        return new InputNumbers(generateSingleNumberList(inputValue));
    }

    private static List<SingleNumber> generateSingleNumberList(String inputValue) {
        List<Integer> inputValues = inputValueToList(inputValue);
        return IntStream.range(0, 3)
                .mapToObj(i -> new SingleNumber(i, inputValues.get(i)))
                .collect(Collectors.toList());
    }

    private static List<Integer> inputValueToList(String inputValue) {
        return IntStream.range(0, 3)
                .mapToObj(i -> Integer.parseInt(inputValue.substring(i, i + 1)))
                .collect(Collectors.toList());
    }

    private static void validateLengthForGame(String inputValue) {
        int length = inputValue.length();

        if (length != 3) {
            throw new IllegalArgumentException("세자리의 숫자를 입력해 주세요.");
        }
    }

    private static void validateDuplicate(String inputValue) {
        long count = IntStream.range(0, 3)
                .mapToObj(inputValue::charAt)
                .distinct()
                .count();

        if (count < 3) {
            throw new IllegalArgumentException("중복 숫자는 입력할 수 없습니다.");
        }
    }
}
