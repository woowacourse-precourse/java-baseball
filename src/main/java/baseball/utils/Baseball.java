package baseball.utils;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import static baseball.values.Constant.Digit.TOTAL_BALL_CNT;

public class Baseball {

    private final LinkedHashSet<Integer> baseballNumber;

    public Baseball(LinkedHashSet<Integer> baseballNumber) {
        this.baseballNumber = baseballNumber;
    }

    public List<Integer> getBaseballNumber() {
        return new ArrayList<>(baseballNumber);
    }

    private static void validateBaseballNumber(LinkedHashSet<Integer> baseballNumber) throws IllegalArgumentException {
        long ballCnt = baseballNumber.stream().distinct().count();
        // LinkedHashSet 사용으로 서로 다른 숫자 검증부 생략
        if (ballCnt != TOTAL_BALL_CNT) {
            throw new IllegalArgumentException("Exception because of inputted Number: " + baseballNumber.toString());
        }
    }
}
