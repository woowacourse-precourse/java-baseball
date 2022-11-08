package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class GameOpponent {
    private List<Integer> targetNumber;

    public GameOpponent(){
        this.targetNumber = Randoms.pickUniqueNumbersInRange(0, 999, 3);
    }
}
