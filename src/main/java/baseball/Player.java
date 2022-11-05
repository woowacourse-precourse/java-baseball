package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Map;

public class Player {

    public Map<Integer, Integer> generate3DigitNumberWithoutDuplication() {
        Map<Integer, Integer> computerNumber = new HashMap<>();

        for (int index = 0; index < 3; ) {
            int picked = Randoms.pickNumberInRange(1, 9);

            if (computerNumber.containsKey(picked)) {
                continue;
            }

            computerNumber.put(picked, index++);
        }

        return computerNumber;
    }

}
