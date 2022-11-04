package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class AnswerGenerator {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 9;
    private static final int VALID_LENGTH = 3;

    public AnswerGenerator() {

    }

    public ArrayList<Integer> generateAnswer() {
        Set<Integer> nums = new HashSet<>();
        while (nums.size() < VALID_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
            nums.add(randomNumber);
        }
        return new ArrayList<>(nums);
    }
}
