package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Computer {
    private static HashMap<Integer, Integer> randomNumberHash = new HashMap<>();

    static HashMap<Integer, Integer> generateRandomNumber() {
        List<Integer> pickedNumbers = new ArrayList<>();
        randomNumberHash.clear();
        int i = 1;
        while (pickedNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!pickedNumbers.contains(randomNumber)) {
                pickedNumbers.add(randomNumber);
                randomNumberHash.put(randomNumber, i);
                i++;
            }
        }
        return randomNumberHash;
    }
}
