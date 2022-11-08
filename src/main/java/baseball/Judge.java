package baseball;

import java.util.LinkedHashMap;

public class Judge {
    public boolean printGameOver(LinkedHashMap<Integer, Integer> computerNumbers,
                                 LinkedHashMap<Integer, Integer> playerNumbers) {
        int sameNumberCount = countSameNumber(computerNumbers, playerNumbers);
        int strikeCount = countStrike(computerNumbers, playerNumbers);
        int ballCount = sameNumberCount - strikeCount;
        printHint(strikeCount, ballCount);
        return (strikeCount == GameConstant.NUMBER_COUNT);
    }

    public int countStrike(LinkedHashMap<Integer, Integer> computerNumbers,
                           LinkedHashMap<Integer, Integer> playerNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < GameConstant.NUMBER_COUNT; i++) {
            if (computerNumbers.get(i) == playerNumbers.get(i)) {
                strikeCount += 1;
            }
        }
        return strikeCount;
    }

    public int countSameNumber(LinkedHashMap<Integer, Integer> computerNumbers,
                               LinkedHashMap<Integer, Integer> playerNumbers) {
        int sameNumberCount = 0;
        for (int i = 0; i < GameConstant.NUMBER_COUNT; i++) {
            if (computerNumbers.containsValue(playerNumbers.get(i))) {
                sameNumberCount += 1;
            }
        }
        return sameNumberCount;
    }

    public void printHint(int strikeCount, int ballCount) {
        String hint = "";
        if (ballCount != 0) {
            hint += (ballCount + GameConstant.BALL);
        }
        if (strikeCount != 0) {
            hint += (strikeCount + GameConstant.STRIKE);
        }
        if (hint.length() == 0) {
            hint += GameConstant.NOTHING;
        }
        System.out.println(hint);
    }
}