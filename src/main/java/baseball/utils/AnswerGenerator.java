package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class AnswerGenerator {
    public static ArrayList<Integer> generateAnswer() {
        Set<Integer> nums = new HashSet<>();
        while (nums.size() < Constants.VALID_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(Constants.VALID_MIN_RANGE, Constants.VALID_MAX_RANGE);
            nums.add(randomNumber);
        }
        return new ArrayList<>(nums);
    }
}

