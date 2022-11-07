package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class AnswerNumber {

    private static final int GAME_ROUND_TOTAL = 3;
    private static final int NUM_MIN = 1;
    private static final int NUM_MAX = 9;

    private final List<Integer> answerNums;

    public AnswerNumber() {
        this.answerNums = createRandNums();
    }

    private List<Integer> createRandNums() {
        List<Integer> randNums = new ArrayList<>();

        while (randNums.size() < GAME_ROUND_TOTAL) {
            int randNum = Randoms.pickNumberInRange(NUM_MIN, NUM_MAX);

            if (!randNums.contains(randNum)) {
                randNums.add(randNum);
            }
        }
        return randNums;
    }

    public List<Integer> get() {
        return answerNums;
    }
}
