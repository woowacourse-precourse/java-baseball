package baseball.domain;

import java.util.List;

import baseball.utils.ListUtility;

public class BaseballNumber {
    public final List<Integer> splitNumber;

    public BaseballNumber(int number) {
        this.splitNumber = ListUtility.splitDigitsIntoList(number);
    }

    public int getNumberAt(int index) {
        return splitNumber.get(index);
    }

    public boolean contains(int number) {
        return splitNumber.contains(number);
    }
}
