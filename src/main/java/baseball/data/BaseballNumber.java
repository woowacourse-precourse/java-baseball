package baseball.data;

import baseball.GameConstant;
import baseball.WarningMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumber {

    private List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void updateNumbers(List<Integer> updateNumbers) {
        numbers = updateNumbers;
        isBetweenOneAndNine();
        isExistDuplicateNumber();
    }

    void isBetweenOneAndNine() {
        for(Integer number : numbers) {
            if(number < 1 || 9 < number) {
                throw new IllegalArgumentException(WarningMessage.IllegalValueWarningMessage.getMessage());
            }
        }
    }

    void isExistDuplicateNumber() {
        Set<Integer> set = new HashSet<>(numbers);
        if(set.size() < GameConstant.DIGIT.getValue()) {
            throw new IllegalArgumentException(WarningMessage.DuplicateValueWarningMessage.getMessage());
        }
    }
}
