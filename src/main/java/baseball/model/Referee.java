package baseball.model;

import java.util.List;

public class Referee {

    public boolean isThreeStrike(List<Integer> offenseNumbers, List<Integer> defenseNumbers) {
        return offenseNumbers.equals(defenseNumbers);
    }

    public boolean isNothing(List<Integer> offenseNumbers, List<Integer> defenseNumbers) {
        return offenseNumbers.stream().noneMatch(defenseNumbers::contains);
    }
}
