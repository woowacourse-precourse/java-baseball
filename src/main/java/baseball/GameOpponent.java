package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class GameOpponent {
    private List<Integer> targetNumber;

    public GameOpponent(){
        this.targetNumber = Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }
    public List<Integer> getTargetNumber(){
        return this.targetNumber;
    }
}
