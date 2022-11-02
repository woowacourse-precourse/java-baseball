package baseball.data;

import baseball.WarningMessage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumbers {

    private static final int DIGIT = 3;

    private List<Integer> baseballNumbers;

    public BaseballNumbers() {
        baseballNumbers = new ArrayList<>(DIGIT);
    }

    public List<Integer> getBaseballNumbers() {
        return this.baseballNumbers;
    }

    public List<Integer> updateNumbers(List<Integer> updateNumbers) {
        this.baseballNumbers = updateNumbers;
        isBetweenOneAndNine();
        isExistDuplicateNumber();

        return this.baseballNumbers;
    }

    public void isBetweenOneAndNine() {
        for(Integer i : this.baseballNumbers) {
            if(i < 1 || 9 < i) {
                throw new IllegalArgumentException(WarningMessage.IllegalValueWarningMessage.getMessage());
            }
        }
    }

    public void isExistDuplicateNumber() {
        Set<Integer> set = new HashSet<>(this.baseballNumbers);
        if(set.size() < DIGIT) {
            throw new IllegalArgumentException(WarningMessage.DuplicateValueWarningMessage.getMessage());
        }
    }
}
