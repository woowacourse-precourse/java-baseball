package domain;

import constant.Messages;

import java.util.List;

public class Numbers {
    private List<Number> numbers;

    public Numbers(List<Number> numbers) {
        isValidSize(numbers);
        isDuplicate(numbers);
        this.numbers = numbers;
    }

    private void isDuplicate(List<Number> numbers) {
        if(numbers.stream().distinct().count() != 3) throw new IllegalArgumentException(Messages.duplicateNumber);
    }

    private void isValidSize(List<Number> numbers) {
        if(numbers.size() != 3) throw new IllegalArgumentException(Messages.wrongInputSize);
    }
}
