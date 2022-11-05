package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberUtil {
    public static List<Integer> createRandomNumber() {
        List<Integer> answerList = new ArrayList<>();

        while (answerList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerList.contains(randomNumber)) {
                answerList.add(randomNumber);
            }
        }

        return answerList;
    }
}
