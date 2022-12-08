package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.utils.BaseBallStatus.*;

public class BaseBallGenerator implements RandomNumberGenerator {

    private static final int ANSWER_SIZE = ANSWER_DEFAULT_SIZE.getCode();
    private static final int MIN = MIN_BASEBALL_NUMBER.getCode();
    private static final int MAX = MAX_BASEBALL_NUMBER.getCode();

    @Override
    public List<Integer> generate() {

        List<Integer> answer = new ArrayList<>();
        while (answer.size() < ANSWER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN, MAX);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }
}
