package baseball.model;

import java.util.List;

public class Judgement {
    private final static int NUMBERS_SIZE = 3;

    private List<Integer> defenseNumbers;

    public Judgement(List<Integer> defenseNumbers) {
        this.defenseNumbers = defenseNumbers;
    }

    public boolean isThreeStrike(List<Integer> offenseNumbers) {
        return offenseNumbers.equals(defenseNumbers);
    }

    public boolean isNothing(List<Integer> offenseNumbers, List<Integer> defenseNumbers) {
        return offenseNumbers.stream().noneMatch(defenseNumbers::contains);
    }
}

