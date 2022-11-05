package baseball;

import java.util.ArrayList;
import java.util.List;

import baseball.utils.Util;

public class BaseballNumber {
    public List<Integer> listNumber;
    BaseballNumber(int number) {
        this.listNumber = Util.splitDigitsIntoList(number);
    }

    public int getNumberAt(int index) {
        return listNumber.get(index);
    }

    public boolean contains(int number) {
        return listNumber.contains(number);
    }
}
