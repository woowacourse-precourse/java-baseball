package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Computer {
    public static List<Integer> createRandomNumber() {
        List<Integer> randomNumber = new ArrayList<>(3);

        while (randomNumber.size() < 3) {
            int temp = Randoms.pickNumberInRange(1, 9);
            if (!randomNumber.contains(temp)) {
                randomNumber.add(temp);
            }
        }

        return randomNumber;
    }

    public static HashMap<String, Integer> getHint(List<Integer> userNumber, List<Integer> goalNumber) {
        HashMap<String, Integer> hint = new HashMap<>();

        return hint;
    }
}
