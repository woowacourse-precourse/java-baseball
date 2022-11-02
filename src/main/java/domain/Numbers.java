package domain;

import constant.Messages;

import java.util.List;

public class Numbers {
    private List<Number> numbers;

    public Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public void isDuplicate(List<Number> numbers) {
        if(numbers.stream().distinct().count() != 3) throw new IllegalArgumentException(Messages.duplicateNumber);
    }

    public void isValidSize(List<Number> numbers) {
        if(numbers.size() != 3) throw new IllegalArgumentException(Messages.wrongInputSize);
    }
}
