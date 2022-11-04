package baseball;

import java.util.ArrayList;
import java.util.List;
import baseball.utils.Util;

public class BaseballNumber {
    private final List<Integer> listNumber;

    BaseballNumber(int number) {
        this.listNumber = Util.splitDigitsIntoList(number);
    }
}
