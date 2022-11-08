package baseball.player;

import baseball.system.constant.BaseballConstant;
import baseball.system.exception.IllegalArgument;
import baseball.utils.*;

import java.util.List;

public class User {
    private List<Integer> userNumbers;

    public void setUser(String inputNumbers) {
        this.userNumbers = createValidNumbers(inputNumbers, BaseballConstant.INPUT_LENGTH,
                BaseballConstant.MIN_NUMBER, BaseballConstant.MAX_NUMBER);
    }

    private List<Integer> createValidNumbers(String inputNumbers, int inputLength, int minNumber, int maxNumber)
            throws IllegalArgumentException {

        if (isOutOfRange(inputNumbers, minNumber, maxNumber)) {
            IllegalArgument.outOfRange(minNumber, maxNumber);
        }

        List<Integer> numbers = NumberParsingCollection.changeStringToIntegers(inputNumbers);

        if (isNotEqualToSetCount(numbers, inputLength)) {
            IllegalArgument.notNNumbers(inputLength);
        }

        if (IsCollection.isDuplication(numbers)) {
            IllegalArgument.duplicateNumberExists();
        }

        return numbers;
    }

    private boolean isOutOfRange(String inputNumbers, int minNumber, int maxNumber) {
        return !IsCollection.isInputNumbersInRange(inputNumbers, minNumber, maxNumber);
    }

    private boolean isNotEqualToSetCount(List<Integer> numbers, int inputLength){
        return !IsCollection.isEqualToSetCount(numbers, inputLength);
    }

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }
}
