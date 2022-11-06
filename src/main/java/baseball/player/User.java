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
        if (!IsCollection.isInputNumbersInRange(inputNumbers,
                BaseballConstant.MIN_NUMBER, BaseballConstant.MAX_NUMBER)) {
            throw new IllegalArgumentException("1~9범위에서 벗어난 숫자입니다.");
        }

        List<Integer> numbers = NumberParsingCollection.changeStringToIntegers(inputNumbers);

        if (!IsCollection.isEqualToSetCount(numbers, BaseballConstant.INPUT_LENGTH)) {
            throw new IllegalArgumentException("3개의 숫자가 아닙니다.");
        }

        if (IsCollection.isDuplication(numbers)) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }

        return numbers;
    }

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }
}
