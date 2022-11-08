package baseball.model;

import java.util.List;

public class Judgement {
    private static final int NUMBERS_SIZE = 3;

    private final List<Integer> defenseNumbers;

    private Judgement(List<Integer> defenseNumbers) {
        this.defenseNumbers = defenseNumbers;
    }

    public static Judgement from(List<Integer> defenseNumbers) {
        return new Judgement(defenseNumbers);
    }

    public boolean isFailureOffense(List<Integer> offenseNumbers) {
        return !offenseNumbers.equals(defenseNumbers);
    }

    public int countBall(List<Integer> offenseNumbers) {
        int sumOfBallAndStrikeCount = countSumOfBallAndStrike(offenseNumbers);
        int strikeCount = countStrike(offenseNumbers);

        return sumOfBallAndStrikeCount - strikeCount;
    }

    private int countSumOfBallAndStrike(List<Integer> offenseNumbers) {
        return (int) offenseNumbers.stream().filter(defenseNumbers::contains).count();
    }

    public int countStrike(List<Integer> offenseNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < NUMBERS_SIZE; i++) {
            Integer offenseNumber = offenseNumbers.get(i);
            Integer defenseNumber = defenseNumbers.get(i);
            
            strikeCount += isStrike(offenseNumber, defenseNumber);
        }
        return strikeCount;
    }

    private int isStrike(Integer offenseNumber, Integer defenseNumber) {
        if (offenseNumber.equals(defenseNumber)) {
            return 1;
        }
        return 0;
    }
}

