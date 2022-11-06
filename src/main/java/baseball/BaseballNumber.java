package baseball;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseballNumber {
    protected List<Integer> baseballNumber;
    protected final int BASEBALLNUMBERLENGTH = 3;

    public List<Integer> getBaseballNumber() {
        return baseballNumber;
    }

    public void setBaseballNumber(List<Integer> baseballNumber) {
        this.baseballNumber = baseballNumber;
    }

    public abstract boolean isValidBaseballNumber (List<Integer> baseballNumber);

    protected boolean isBaseballNumberLength3(List<Integer> baseballNumber) {
        return baseballNumber.size() == this.BASEBALLNUMBERLENGTH;
    }

    protected boolean isNotDuplicatedNumber(List<Integer> baseballNumber) {
        int deleteDuplicateLength = (int) baseballNumber.stream().distinct().count();
        return deleteDuplicateLength == this.BASEBALLNUMBERLENGTH;
    }

    protected boolean isValidRange(List<Integer> baseballNumber) {
        int checkNumberRange = (int) baseballNumber.stream()
                .filter(num -> num > 0 && num <= 9)
                .count();

        return checkNumberRange == this.BASEBALLNUMBERLENGTH;
    }
}
