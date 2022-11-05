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

    private static List<Integer> numToDigitList(int num) {
        List<Integer> list = new ArrayList<>(Collections.nCopies(SIZE, 0));
        int idx = SIZE - 1;
        while (num > 0) {
            validateIdx(idx);
            list.set(idx, num % 10);

            num /= 10;
            idx = getNextIdx(idx);
        }
        return list;
    }

    private static void validateIdx(int idx) {
        if (idx < 0) {
            throw new IllegalArgumentException(OVER_SIZE_MESSAGE);
        }
    }

    private static int getNextIdx(int idx) {
        return idx - 1;
    }

    public List<Integer> list() {
        return this.value;
    }

    private void validateValue() {
        validateSize();
        List<Boolean> freq = new ArrayList<>(Collections.nCopies(END_RANGE + 1, false));

        for (int valueEach : value) {
            validateValue(freq, valueEach);
            freq.set(valueEach, true);
        }
    }

    private static void validateValue(List<Boolean> freq, int valueEach) {
        if (!isValidRange(valueEach)) {
            throw new IllegalArgumentException(INVALID_DIGIT_MESSAGE);
        }
        if (isUsedValue(freq, valueEach)) {
            throw new IllegalArgumentException(DUPLICATE_DIGIT_MESSAGE);
        }
    }

    private static Boolean isUsedValue(List<Boolean> freq, int valueEach) {
        return freq.get(valueEach);
    }

    private static boolean isValidRange(int valueEach) {
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
