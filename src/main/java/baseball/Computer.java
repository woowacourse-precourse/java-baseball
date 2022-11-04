package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Computer {

    private static final Integer MIN_VALUE = 1;
    private static final Integer MAX_VALUE = 9;
    private static final Integer ANSWER_LENGTH = 3;

    private List<Integer> answer;

    public Computer() {
        init();
    }

    private void init() {
        answer = Randoms.pickUniqueNumbersInRange(MIN_VALUE, MAX_VALUE, ANSWER_LENGTH);
    }
}
