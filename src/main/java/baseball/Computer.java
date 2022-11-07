package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public String generateRandomNumbersString() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < Game.LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers.toString().replaceAll("[^1-9]", "");
    }
}
