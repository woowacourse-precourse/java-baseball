package baseball.domain.ingame;

import static baseball.domain.baseballnumber.BaseballNumberListGenerator.baseballNumberList;

import baseball.domain.baseballnumber.BaseballNumber;
import java.util.List;
import java.util.stream.IntStream;

public class Guess {

    private final List<BaseballNumber> inputNumbers;

    public Guess(String inputValue) {
        validateLengthForGame(inputValue);
        validateDuplicate(inputValue);
        this.inputNumbers = baseballNumberList(inputValue);
    }

    int ballCount(List<BaseballNumber> answer) {
        return (int) inputNumbers.stream()
                .filter(baseballNumber -> !answer.contains(baseballNumber))
                .filter(baseballNumber -> baseballNumber.equalsOnlyNumber(answer))
                .count();
    }

    int strikeCount(List<BaseballNumber> answer) {
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
