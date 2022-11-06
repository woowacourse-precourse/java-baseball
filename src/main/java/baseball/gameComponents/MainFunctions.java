package baseball.gameComponents;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class MainFunctions {
    public List<Integer> generateRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }
}
