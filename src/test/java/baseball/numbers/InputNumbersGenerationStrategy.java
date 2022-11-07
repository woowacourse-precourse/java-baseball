package baseball.numbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputNumbersGenerationStrategy implements NumbersGenerationStrategy {
    private static final int NUMBERS_COUNT = 3;

    private List<Integer> numbers;

    private int sequence = 0;

    public InputNumbersGenerationStrategy(Integer... numbers) {
        this.numbers = Arrays.stream(numbers)
                .collect(Collectors.toList());
    }

    public InputNumbersGenerationStrategy(List<Integer>... numbers) {
        this.numbers = Arrays.stream(numbers)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> numbers() {
        List<Integer> result = numbers.subList(sequence, sequence + NUMBERS_COUNT);
        sequence += NUMBERS_COUNT;
        return result;
    }
}
