package baseball.domain.game_number;

import baseball.domain.number.SingleNumber;
import baseball.domain.number.SingleNumbersGenerator;

import java.util.List;
import java.util.stream.IntStream;

public class Guess {

    private final List<SingleNumber> inputNumbers;

    public Guess(String inputValue) {
        validateLengthForGame(inputValue);
        validateDuplicate(inputValue);
        this.inputNumbers = SingleNumbersGenerator.singleNumberList(inputValue);
    }

    int ballCount(List<SingleNumber> answer) {
        return (int) inputNumbers.stream()
                .filter(singleNumber -> !answer.contains(singleNumber))
                .filter(singleNumber -> singleNumber.equalsOnlyNumber(answer))
                .count();
    }

    int strikeCount(List<SingleNumber> answer) {
        return (int) inputNumbers.stream()
                .filter(answer::contains)
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
