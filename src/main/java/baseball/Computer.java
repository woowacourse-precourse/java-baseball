package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Computer {
    public LinkedHashMap<Integer, Integer> pickNumbers() {
        LinkedHashMap<Integer, Integer> computerNumbers = new LinkedHashMap<>();
        List<Integer> randomNumbers = generateUniqueRandomNumbers();
        for (int i = 0; i < GameConstant.NUMBER_COUNT; i++) {
            computerNumbers.put(i, randomNumbers.get(i));
        }
        return computerNumbers;
    }

    private List<Integer> generateUniqueRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < GameConstant.NUMBER_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(GameConstant.MIN_VALUE, GameConstant.MAX_VALUE);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }
}
