package baseball.model;

import baseball.Constant;
import java.util.List;

public class User {
    private List<Integer> inputNum;

    public User(List<Integer> inputNum) {
        if (!validCheck(inputNum)) {
            throw new IllegalArgumentException();
        }
        this.inputNum = inputNum;
    }

    private boolean validCheck(List<Integer> inputNum) {
        return isThreeInSize(inputNum) && isComposedUniqueNumber(inputNum) && isNumberFromOneToNine(inputNum);
    }

    private boolean isNumberOfList(List<Integer> inputNum) {
        return true;
    }

    private boolean isThreeInSize(List<Integer> inputNum) {
        return inputNum.size() == Constant.DIGIT_SIZE;
    }

    private boolean isComposedUniqueNumber(List<Integer> inputNum) {
        return inputNum.stream().distinct().count() == inputNum.size();
    }

    private boolean isNumberFromOneToNine(List<Integer> inputNum) {
        for (int number : inputNum) {
            if (number < Constant.MINIMUM_RANGE || number > Constant.MAXIMUM_RANGE) {
                return false;
            }
        }
        return true;
    }
}
