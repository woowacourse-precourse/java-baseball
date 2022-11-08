package baseball;

import java.util.LinkedHashMap;

public class Judge {
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
}
