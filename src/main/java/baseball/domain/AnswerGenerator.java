package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class AnswerGenerator {

    public static List<Integer> createAnswer() {
        List<Integer> computerBalls = new ArrayList<>();
        while (computerBalls.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerBalls.contains(randomNumber)) {
                computerBalls.add(randomNumber);
            }
        }
        return computerBalls;
    }

}
