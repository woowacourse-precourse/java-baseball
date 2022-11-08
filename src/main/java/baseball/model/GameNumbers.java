package baseball.model;

import java.util.List;

abstract class GameNumbers {
    static final int NUMBER_COUNT = 3;
    static final int START_INCLUSIVE = 1;
    static final int END_INCLUSIVE = 9;

    void addValidNumber(List<Integer> numberList, int number) {
        if (isAddable(numberList, number)) {
            numberList.add(number);
        }
    }

    abstract boolean isAddable(List<Integer> numberList, int number);
}
