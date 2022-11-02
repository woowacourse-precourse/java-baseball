package domain;

import constant.Messages;

import java.util.List;
import java.util.stream.IntStream;

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

    public int checkStrike(Numbers userNumber) {
        return (int) IntStream.range(0, 3)
                .filter(value -> numbers.get(value).equals(userNumber.numbers.get(value)))
                .count();
    }


    public int checkBall(Numbers userNumber) {
        int count = 0;
        if(numbers.get(0).equals(userNumber.numbers.get(1)) || numbers.get(0).equals(userNumber.numbers.get(2)))
            count += 1;
        if(numbers.get(1).equals(userNumber.numbers.get(0)) || numbers.get(1).equals(userNumber.numbers.get(2)))
            count += 1;
        if(numbers.get(2).equals(userNumber.numbers.get(0)) || numbers.get(2).equals(userNumber.numbers.get(1)))
            count += 1;
        return count;
    }
}
