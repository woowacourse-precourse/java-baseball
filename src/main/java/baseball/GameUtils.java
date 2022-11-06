package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class GameUtils {
    protected List<Integer> generateRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }
}
