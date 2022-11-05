package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OneDigitNumbers {
    private final List<Integer> oneDigitNumbers;

    public OneDigitNumbers(int number) {
        this.oneDigitNumbers = this.splitFrom(number);
    }

    public OneDigitNumbers(List<Integer> oneDigitNumber) {
        this.oneDigitNumbers = oneDigitNumber;
    }

    public OneDigitNumbers retainAll(OneDigitNumbers oneDigitNumbers) {
        List<Integer> newNumbers = new ArrayList<>(this.oneDigitNumbers);
        newNumbers.retainAll(oneDigitNumbers.toList());

        return new OneDigitNumbers(newNumbers);
    }

    public long size() {
        return this.size(false);
    }

    public long size(boolean deduplicate) {
        if (deduplicate) {
            return this.oneDigitNumbers.stream().distinct().count();
        }

        return this.oneDigitNumbers.size();
    }

    public List<Integer> toList() {
        return this.oneDigitNumbers;
    }

    private List<Integer> splitFrom(int number) {
        List<Integer> oneDigitNumbers = new ArrayList<>();

        while (number > 0) {
            oneDigitNumbers.add(number % 10);
            number /= 10;
        }

        Collections.reverse(oneDigitNumbers);

        return oneDigitNumbers;
    }
}
