package baseball.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Numbers {

    private static final int NUMBER_SIZE = 3;
    private static final String NUMBER_SIZE_EXCEPTION = "숫자는 " + NUMBER_SIZE + "개여야 합니다.";
    private static final String DIFFERENT_EACH_NUMBER_EXCEPTION = "서로 다른 " + NUMBER_SIZE + "개의 숫자여야 합니다.";
    private final List<Number> numbers;

    public Numbers(Integer... ints) {
        this(Arrays.stream(ints).collect(Collectors.toList()));
    }

    public Numbers(List<Integer> ints) {
        List<Number> numbers = ints.stream()
                .map(Number::of)
                .collect(Collectors.toList());

        validateNumbersSize(numbers);
        validateDifferentEachNumber(numbers);
        this.numbers = numbers;
    }

    private void validateNumbersSize(List<Number> numberList) {
        if (numberList.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException(NUMBER_SIZE_EXCEPTION);
        }
    }

    private void validateDifferentEachNumber(List<Number> numberList) {
        if (numberList.stream().distinct().count() != NUMBER_SIZE) {
            throw new IllegalArgumentException(DIFFERENT_EACH_NUMBER_EXCEPTION);
        }
    }

    public Hints compare(Numbers matchNumbers) {
        List<Hint> hintList = IntStream.range(0, NUMBER_SIZE)
                .mapToObj(number -> hint(matchNumbers, number))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        return new Hints(hintList);
    }

    private Hint hint(Numbers matchNumbers, int index) {
        if (this.numbers.get(index).equals(matchNumbers.numbers.get(index))) {
            return Hint.STRIKE;
        }
        if (this.numbers.contains(matchNumbers.numbers.get(index))) {
            return Hint.BALL;
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Numbers numbers1 = (Numbers) o;
        return Objects.equals(numbers, numbers1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
