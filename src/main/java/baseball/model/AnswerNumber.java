package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class AnswerNumber {

    private static final int ANSWER_NUM_SIZE = 3;
    private static final int NUM_MIN = 1;
    private static final int NUM_MAX = 9;

    private final List<Integer> nums;

    public AnswerNumber() {
        this.nums = createRandNums();
    }

    private List<Integer> createRandNums() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < ANSWER_NUM_SIZE) {
            int randNum = Randoms.pickNumberInRange(NUM_MIN, NUM_MAX);

            if (!numbers.contains(randNum)) {
                numbers.add(randNum);
            }
        }
        return numbers;
    }

    public List<Integer> get() {
        return nums;
    }
}
