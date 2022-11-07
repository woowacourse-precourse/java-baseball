package baseball.domain;

import java.util.List;

import baseball.utils.ListUtility;

public class BaseballNumber {
    public final List<Integer> splittedNumber;

    public BaseballNumber(int number) {
        this.splittedNumber = ListUtility.splitDigitsIntoList(number);
    }

    public int getNumberAt(int index) {
        return splittedNumber.get(index);
    }

    public boolean contains(int number) {
        return splittedNumber.contains(number);
    }
}
