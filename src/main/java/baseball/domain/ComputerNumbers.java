package baseball.domain;

import java.util.List;
import java.util.stream.IntStream;

import static baseball.type.BaseballBound.BASEBALL_MAX_SIZE;

public class ComputerNumbers {
    static final int START_INDEX = 0;
    private final List<Integer> computerNumbers;

    public ComputerNumbers(List<Integer> computerNumbers) {
        this.computerNumbers = computerNumbers;
    }

    public int countStrikes(BaseballNumbers baseballNumbers) {
        return (int) IntStream.range(START_INDEX, BASEBALL_MAX_SIZE.getValue())
                .filter(i -> computerNumbers.get(i).equals(baseballNumbers.numbers.get(i)))
                .count();
    }

    public int countBalls(BaseballNumbers baseballNumbers) {
        return (int) IntStream.range(START_INDEX, BASEBALL_MAX_SIZE.getValue())
                .filter(i -> {
                    return (!this.computerNumbers.get(i).equals(baseballNumbers.numbers.get(i))) &&
                            (baseballNumbers.numbers.stream()
                                    .anyMatch(number -> number.equals(this.computerNumbers.get(i))));
                })
                .count();
    }
}
