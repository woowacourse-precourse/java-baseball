package baseball.domain.inputnumber;

import baseball.domain.SingleNumber;
import baseball.domain.SingleNumberUtils;

import java.util.List;
import java.util.stream.IntStream;

public class InputNumbers {

    private final List<SingleNumber> inputNumbers;

    public InputNumbers(String inputValue) {
        validateLengthForGame(inputValue);
        validateDuplicate(inputValue);
        this.inputNumbers = SingleNumberUtils.singleNumberList(inputValue);
    }

    public int ballCount(List<SingleNumber> randomNumbers) {
        return (int) inputNumbers.stream()
                .filter(singleNumber -> !randomNumbers.contains(singleNumber))
                .filter(singleNumber -> singleNumber.isBall(randomNumbers))
                .count();
    }

    public int strikeCount(List<SingleNumber> randomNumbers) {
        return (int) inputNumbers.stream()
                .filter(randomNumbers::contains)
                .count();
    }

    private void validateLengthForGame(String inputValue) {
        int length = inputValue.length();

        if (length != 3) {
            throw new IllegalArgumentException("세자리의 숫자를 입력해 주세요.");
        }
    }

    private void validateDuplicate(String inputValue) {
        long count = IntStream.range(0, 3)
                .mapToObj(inputValue::charAt)
                .distinct()
                .count();

        if (count < 3) {
            throw new IllegalArgumentException("중복 숫자는 입력할 수 없습니다.");
        }
    }
}
