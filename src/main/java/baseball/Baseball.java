package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Baseball {
    public static List<Integer> getRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }
}
