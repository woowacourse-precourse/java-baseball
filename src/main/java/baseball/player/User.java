package baseball.player;

import baseball.system.BaseballConstant;
import baseball.utils.*;

import java.util.List;

public class User {
    private List<Integer> userNumbers;

    public void setUser(String inputNumbers) {
        this.userNumbers = createValidNumbers(inputNumbers);
    }

    private List<Integer> createValidNumbers(String inputNumbers) throws IllegalArgumentException {
        if (!IsCollection.isInputNumbersInRange(
                inputNumbers,
                BaseballConstant.MIN_NUMBER,
                BaseballConstant.MAX_NUMBER)) {
            throw new IllegalArgumentException();
        }

        List<Integer> numbers = NumberParsingCollection.changeStringToIntegers(inputNumbers);

        if (!IsCollection.isEqualToSetCount(numbers, BaseballConstant.INPUT_LENGTH) ||
                IsCollection.isDuplication(numbers)) {
            throw new IllegalArgumentException();
        }

        return numbers;
    }

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }
}
