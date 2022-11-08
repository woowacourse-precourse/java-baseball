package baseball.player;

import static baseball.Constant.LENGTH_OF_NUMBER;
import static baseball.Constant.NUM_MAX_RANGE;
import static baseball.Constant.NUM_MIN_RANGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> number = new ArrayList<>();

    public List<Integer> createNumber() {
        while (number.size() < LENGTH_OF_NUMBER) {
            int pickNumberInRange = Randoms.pickNumberInRange(NUM_MIN_RANGE, NUM_MAX_RANGE);
            if (!number.contains(pickNumberInRange)) {
                number.add(pickNumberInRange);
            }
        }
        return number;
    }

}
