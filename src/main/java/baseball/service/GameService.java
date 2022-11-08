package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class GameService {

    public List<Integer> makeRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }
}
