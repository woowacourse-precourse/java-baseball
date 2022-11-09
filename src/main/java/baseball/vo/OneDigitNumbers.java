package baseball.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class OneDigitNumbers implements Iterable<Integer> {
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
    
    public int indexOf(int index) {
        return this.oneDigitNumbers.indexOf(index);
    }

    public boolean contains(int number) {
        return this.oneDigitNumbers.contains(number);
    }

    public List<Integer> toList() {
        return this.oneDigitNumbers;
    }

    public void validate() {
        if (this.size() != 3) {
            throw new IllegalArgumentException("3자리의 숫자를 입력해주세요.");
        }

        if (this.size(true) != 3) {
            throw new IllegalArgumentException("각각의 3자리 숫자가 중복되지 않게 입력해주세요.");
        }

        if (!this.oneDigitNumbers.stream().allMatch(oneDigitNumber -> oneDigitNumber > 0)) {
            throw new IllegalArgumentException("각가의 3자리 숫자에 0이 포함되지 않게 입력해주세요.");
        }
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

    @Override
    public Iterator<Integer> iterator() {
        return new OneDigitNumbersIterator();
    }

    class OneDigitNumbersIterator implements Iterator<Integer> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < oneDigitNumbers.size();
        }

        @Override
        public Integer next() {
            return oneDigitNumbers.get(index++);
        }
    }
}