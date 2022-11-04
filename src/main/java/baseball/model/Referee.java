package baseball.model;

import java.util.List;

public class Referee {

    public boolean isThreeStrike(List<Integer> offenseNumbers, List<Integer> defenseNumbers) {
        if (offenseNumbers.equals(defenseNumbers)) {
            return true;
        }
        return false;
    }
}
