package baseball.data;

import baseball.WarningMessage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumber {

    private static final int DIGIT = 3;

    private static BaseballNumber baseballNumber;
    private static List<Integer> baseballNumberList;

    private BaseballNumber() {
        baseballNumberList = new ArrayList<>();
    }

    public static BaseballNumber getInstance() {
        if(baseballNumber == null) {
            baseballNumber = new BaseballNumber();
        }

        return baseballNumber;
    }

    public BaseballNumber updateNumbers(List<Integer> updateNumbers) {
        baseballNumberList = updateNumbers;
        isBetweenOneAndNine();
        isExistDuplicateNumber();

        return this.baseballNumber;
    }

    private void isBetweenOneAndNine() {
        for(Integer i : baseballNumberList) {
            if(i < 1 || 9 < i) {
                throw new IllegalArgumentException(WarningMessage.IllegalValueWarningMessage.getMessage());
            }
        }
    }

    private void isExistDuplicateNumber() {
        Set<Integer> set = new HashSet<>(baseballNumberList);
        if(set.size() < DIGIT) {
            throw new IllegalArgumentException(WarningMessage.DuplicateValueWarningMessage.getMessage());
        }
    }
}
