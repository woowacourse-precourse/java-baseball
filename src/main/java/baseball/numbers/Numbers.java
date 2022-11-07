package baseball.numbers;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Numbers {
    private static final int NUMBERS_COUNT = 3;
    private static final String SPACE = "";

    private final List<Number> numbers;

    public Numbers(String input) {
        this(convert(input));
    }

    public Numbers(NumbersGenerationStrategy strategy) {
        this(strategy.numbers());
    }

    public Numbers(List<Integer> numbers) {
        if (numbers == null || distinct(numbers).size() != NUMBERS_COUNT) {
            throw new IllegalArgumentException();
        }
        this.numbers = numbers.stream()
                .map(Number::from)
                .collect(Collectors.toList());
    }

    public Map<BallTypes, Integer> compare(Numbers other) {
        Map<BallTypes, Integer> result = initialResult();
        for (int sequence = 0; sequence < NUMBERS_COUNT; sequence++) {
            BallTypes type = other.contains(sequence, numbers.get(sequence));
            result.put(type, result.get(type) + 1);
        }
        return result;
    }

    private static List<Integer> convert(String input) {
        return Arrays.stream(input.split(SPACE))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private List<Integer> distinct(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    private BallTypes contains(int sequence, Number number) {
        if (numbers.get(sequence) == number) {
            return BallTypes.STRIKE;
        }

        if (numbers.contains(number)) {
            return BallTypes.BALL;
        }

        return BallTypes.MISS;
    }

    private Map<BallTypes, Integer> initialResult() {
        Map<BallTypes, Integer> result = new EnumMap<>(BallTypes.class);
        result.put(BallTypes.STRIKE, 0);
        result.put(BallTypes.BALL, 0);
        result.put(BallTypes.MISS, 0);
        return result;
    }
}
