package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreeDigitNum {

    static final int START_RANGE = 1;
    static final int END_RANGE = 9;
    static final int SIZE = 3;
    private List<Integer> value = null;

    public ThreeDigitNum(List<Integer> list) {
        value = list;
        validateValue();
    }

    public List<Integer> list() {
        return this.value;
    }

    private void validateValue() {
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
