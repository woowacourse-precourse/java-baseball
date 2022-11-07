package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreeDigitNum {

    public static final int START_RANGE = 1;
    public static final int END_RANGE = 9;
    public static final int SIZE = 3;

    public static final String OVER_SIZE_MESSAGE = "야구게임 값이 3자리 수를 초과했습니다.";
    public static final String INVALID_SIZE_MESSAGE = "야구게임 값은 3자리 수여야 합니다.";
    public static final String INVALID_DIGIT_MESSAGE = "야구게임 값의 각 자릿수는 1 ~ 9사이여야 합니다.";
    public static final String DUPLICATE_DIGIT_MESSAGE = "야구 게임의 값의 각 자릿수는 서로 달라야 합니다.";

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
            throw new IllegalArgumentException(OVER_SIZE_MESSAGE);
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
            throw new IllegalArgumentException(INVALID_DIGIT_MESSAGE);
        }
        if (isUsedValue(freq, valueEach)) {
            throw new IllegalArgumentException(DUPLICATE_DIGIT_MESSAGE);
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
            throw new IllegalArgumentException(INVALID_SIZE_MESSAGE);
        }
    }

    private boolean isValidSize() {
        return value.size() == ThreeDigitNum.SIZE;
    }
}
