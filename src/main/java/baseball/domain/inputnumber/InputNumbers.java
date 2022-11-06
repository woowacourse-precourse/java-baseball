package baseball.domain.inputnumber;

import baseball.domain.SingleNumber;

import java.util.List;

public class InputNumbers {

    private final List<SingleNumber> inputNumbers;

    InputNumbers(List<SingleNumber> inputNumbers) {
        this.inputNumbers = inputNumbers;
    }

    public int ballCount(List<SingleNumber> randomNumbers) {
        return (int) inputNumbers.stream()
                .filter(singleNumber -> singleNumber.isBall(randomNumbers))
                .count();
    }

    public int strikeCount(List<SingleNumber> randomNumbers) {
        return (int) inputNumbers.stream()
                .filter(randomNumbers::contains)
                .count();
    }
}
