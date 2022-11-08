package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static baseball.Constants.ANSWER_NUM_CNT;
import static baseball.Constants.ANSWER_NUM_RANGE_START;
import static baseball.Constants.ANSWER_NUM_RANGE_END;

public class RandomNum {
    public static List<Integer> generate() {
        List<Integer> numList = new ArrayList<>();
        boolean[] hasNum = new boolean[ANSWER_NUM_RANGE_END];
        Arrays.fill(hasNum, Boolean.FALSE);

        while (numList.size() < ANSWER_NUM_CNT) {
            int newNum = Randoms.pickNumberInRange(ANSWER_NUM_RANGE_START, ANSWER_NUM_RANGE_END);

            if (!hasNum[newNum - 1]) {
                numList.add(newNum);
                hasNum[newNum - 1] = true;
            }
        }

        return numList;
    }
}
