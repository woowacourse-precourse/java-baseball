package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Balls {

    private List<Ball> balls;

    public Balls(List<Integer> numbers) {
        Set<Integer> numberSet = setBallNumber();
        if (isOkaySize(numbers)) {
            throw new IllegalArgumentException();
        }

        if (isSameSize(numbers, numberSet)) {
            throw new IllegalArgumentException();
        }

    }

    public static Balls from(List<Integer> numbers) {
        return new Balls(numbers);
    }

    private boolean isOkaySize(List<Integer> numbers) {
        return numbers.size() != 3;
    }

    private boolean isSameSize(List<Integer> numbers, Set<Integer> numberSet) {
        return numbers.size() != numberSet.size();
    }

    private Set<Integer> setBallNumber() {
        Set<Integer> testNumbers = new HashSet<>();
        for (Integer number : testNumbers) {
            testNumbers.add(number);
        }
        return testNumbers;
    }


}
