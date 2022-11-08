package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Computer {
    private static HashMap<Integer, Integer> RandomNumberHash = new HashMap<>();

    static HashMap<Integer, Integer> generateRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        RandomNumberHash.clear();
        int i = 1;
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
                RandomNumberHash.put(randomNumber, i);
                i++;
            }
        }
        return RandomNumberHash;
    }
}
