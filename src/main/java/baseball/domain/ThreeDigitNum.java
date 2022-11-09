package baseball.domain;

import baseball.enums.ErrorMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreeDigitNum {

    public static final int START_RANGE = 1;
    public static final int END_RANGE = 9;
    public static final int SIZE = 3;


    private List<Integer> value;

    public ThreeDigitNum(List<Integer> list) {
        value = list;
        validateValue();
    }

    public ThreeDigitNum(int num) {
        value = numToDigitList(num);
        validateValue();
    }

    private List<Integer> numToDigitList(int num) {
        List<Integer> list = zeroFillFor(SIZE);
        int idx = SIZE - 1;
        while (num > 0) {
            validateIdx(idx);
            list.set(idx, digitOf(num));

            num = subtractLastDigit(num);
            idx = getNextIdx(idx);
        }
        return list;
    }

    private List<Integer> zeroFillFor(int size) {
        List<Integer> list = new ArrayList<>(Collections.nCopies(size, 0));
        return list;
    }

    private int subtractLastDigit(int num) {
        num /= 10;
        return num;
    }

    private int digitOf(int num) {
        return num % 10;
    }

    private void validateIdx(int idx) {
        if (idx < 0) {
            throw new IllegalArgumentException(ErrorMessage.OVER_SIZE.value());
        }
    }

    private static int getNextIdx(int idx) {
        return idx - 1;
    }

    public List<Integer> list() {
        return copiedValue();
    }

    private List<Integer> copiedValue() {
        List<Integer> ret = zeroFillFor(SIZE);

        for(int i=0;i< value.size();++i) {
            ret.set(i, value.get(i));
        }

        return ret;
    }

    private void validateValue() {
        validateSize();
        List<Boolean> freq = falseFillFor(END_RANGE + 1);

        for (int valueEach : value) {
            validateValue(freq, valueEach);
            freq.set(valueEach, true);
        }
    }

    private static List<Boolean> falseFillFor(int size) {
        return new ArrayList<>(Collections.nCopies(size, false));
    }

    private void validateValue(List<Boolean> freq, int valueEach) {
        if (!isValidRange(valueEach)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DIGIT.value());
        }
        if (isUsedValue(freq, valueEach)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_DIGIT.value());
        }
    }

    private Boolean isUsedValue(List<Boolean> freq, int valueEach) {
        return freq.get(valueEach);
    }

    private boolean isValidRange(int valueEach) {
        return START_RANGE <= valueEach && valueEach <= END_RANGE;
    }

    private void validateSize() {
        if (!isValidSize()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_SIZE.value());
        }
    }

    private boolean isValidSize() {
        return value.size() == ThreeDigitNum.SIZE;
    }
}
