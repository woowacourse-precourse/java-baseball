package baseball.domain;

import java.util.List;

import baseball.utils.Utility;

public class BaseballNumber {
    public List<Integer> listNumber;
    public BaseballNumber(int number) {
        this.listNumber = Utility.splitDigitsIntoList(number);
    }

    public int getNumberAt(int index) {
        return listNumber.get(index);
    }

    public boolean contains(int number) {
        return listNumber.contains(number);
    }
}
