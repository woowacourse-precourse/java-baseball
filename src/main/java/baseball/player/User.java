package baseball.player;

import baseball.system.constant.BaseballConstant;
import baseball.system.exception.IllegalArgument;
import baseball.utils.*;

import java.util.List;

public class User {
    private List<Integer> userNumbers;

    public void setUser(String inputNumbers) {
        this.userNumbers = createValidNumbers(inputNumbers);
    }

    private List<Integer> createValidNumbers(String inputNumbers) throws IllegalArgumentException {

        final int MIN_NUMBER = BaseballConstant.MIN_NUMBER;
        final int MAX_NUMBER = BaseballConstant.MAX_NUMBER;
        final int INPUT_LENGTH = BaseballConstant.INPUT_LENGTH;

        if (!IsCollection.isInputNumbersInRange(inputNumbers, MIN_NUMBER, MAX_NUMBER)) {
            IllegalArgument.outOfRange(MIN_NUMBER, MAX_NUMBER);
        }

        List<Integer> numbers = NumberParsingCollection.changeStringToIntegers(inputNumbers);

        if (!IsCollection.isEqualToSetCount(numbers, INPUT_LENGTH)) {
            IllegalArgument.notNNumbers(INPUT_LENGTH);
        }

        if (IsCollection.isDuplication(numbers)) {
            IllegalArgument.duplicateNumberExists();
        }

        return numbers;
    }

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }
}
