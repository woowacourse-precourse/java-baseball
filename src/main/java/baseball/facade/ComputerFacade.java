package baseball.facade;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerFacade {
    private final static int VALUE_SIZE = 3;

    public List<Integer> getRandomValue() {
        List<Integer> randomValue = new ArrayList<>();
        while(randomValue.size() < VALUE_SIZE) {
            int randNum = Randoms.pickNumberInRange(1, 9);
            if (!randomValue.contains(randNum)) {
                randomValue.add(randNum);
            }
        }

        return randomValue;
    }
}
