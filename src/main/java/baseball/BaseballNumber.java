package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseballNumber {
    private final List<Integer> listNumber;

    BaseballNumber(int number) {
        listNumber = splitDigitsIntoList(number);
    }
}
