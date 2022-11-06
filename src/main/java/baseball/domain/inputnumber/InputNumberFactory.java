package baseball.domain.inputnumber;

import java.util.stream.IntStream;

import static baseball.domain.SingleNumberUtils.singleNumberList;

public class InputNumberFactory {

    public static InputNumbers newInstance(String inputValue) {
        validateLengthForGame(inputValue);
        validateDuplicate(inputValue);
        return new InputNumbers(singleNumberList(inputValue));
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
