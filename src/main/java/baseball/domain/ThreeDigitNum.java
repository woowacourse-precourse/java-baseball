package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreeDigitNum {

    public static final int START_RANGE = 1;
    public static final int END_RANGE = 9;
    public static final int SIZE = 3;
    private List<Integer> value = null;

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
        int idx = SIZE -1;
        while(num > 0) {
            list.set(idx, num % 10);

            num /= 10;
            idx = getNextIdx(idx);
        }
        return list;
    }

    private static int getNextIdx(int idx) {
        if(idx -1 < 0) {
            throw new IllegalArgumentException("야구게임 값이 3자리 수를 초과했습니다.");
        }
        idx = idx -1;
        return idx;
    }

    public List<Integer> list() {
        return this.value;
    }

    private void validateValue() {
        if(value.size() != 3) {
            throw new IllegalArgumentException("야구게임 값은 3자리 수여야 합니다.");
        }
        List<Integer> freq = new ArrayList<>(Collections.nCopies(END_RANGE + 1, 0));

        for (int valueEach : value) {
            if (valueEach < START_RANGE | valueEach > END_RANGE) {
                throw new IllegalArgumentException("야구게임 값의 각 자릿수는 1 ~ 9사이여야 합니다.");
            }
            if (freq.get(valueEach) != 0) {
                throw new IllegalArgumentException("야구 게임의 값의 각 자릿수는 서로 달라야 합니다.");
            }

            freq.set(valueEach, 1);
        }
    }
}
