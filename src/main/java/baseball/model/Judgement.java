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

    public List<Integer> judgeOffenseNumbers(List<Integer> offenseNumbers) {
        int strikeNumber = countStrike(offenseNumbers);
        int ballNumber = countBall(offenseNumbers);
        return List.of(ballNumber, strikeNumber);
    }

    private int countBall(List<Integer> offenseNumbers) {
        int totalCount = countSumOfBallAndStrike(offenseNumbers);
        int strikeCount = countStrike(offenseNumbers);
        return totalCount - strikeCount;
    }

    private int countSumOfBallAndStrike(List<Integer> offenseNumbers) {
        return (int) offenseNumbers.stream().filter(defenseNumbers::contains).count();
    }

    private int countStrike(List<Integer> offenseNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < NUMBERS_SIZE; i++) {
            if (offenseNumbers.get(i) == defenseNumbers.get(i)) {
                strikeCount += 1;
            }
        }
        return strikeCount;
    }
}

