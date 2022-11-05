package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Numbers {

    private static final int NUMBER_SIZE = 3;
    private final List<Number> numbers;

    public Numbers(int... ints) {
        this(Arrays.stream(ints)
                .mapToObj(Number::of)
                .collect(Collectors.toList()));
    }

    public Numbers(List<Number> numberList) {
        validateNumbersSize(numberList);
        validateDifferentEachNumber(numberList);
        this.numbers = numberList;
    }

    private void validateNumbersSize(List<Number> numberList) {
        if (numberList.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException("숫자는 " + NUMBER_SIZE + "개여야 합니다.");
        }
    }

    private void validateDifferentEachNumber(List<Number> numberList) {
        if (numberList.stream().distinct().count() != NUMBER_SIZE) {
            throw new IllegalArgumentException("서로 다른 3개의 숫자여야 합니다.");
        }
    }

    public Hints match(Numbers matchNumbers) {
        List<Hint> hints = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            Number number = numbers.get(i);
            if (matchNumbers.numbers.get(i).equals(number)) {
                hints.add(Hint.STRIKE);
                continue;
            }
            if (matchNumbers.numbers.contains(number)) {
                hints.add(Hint.BALL);
            }
        }
        return new Hints(hints);
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
