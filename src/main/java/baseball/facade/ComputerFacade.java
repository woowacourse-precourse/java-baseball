package baseball.facade;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class ComputerFacade {
    private final static int VALUE_SIZE = 3;

    public List<Integer> getRandomValue() {
        return Randoms.pickUniqueNumbersInRange(1, 9, VALUE_SIZE);
    }
}
