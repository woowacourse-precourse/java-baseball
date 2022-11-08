package baseball.compute;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class computer {
    private List<Integer> makeRandom() {
        List<Integer> randomnumbers = new ArrayList<>();
        while (randomnumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomnumbers.contains(randomNumber)) {
                randomnumbers.add(randomNumber);
            }
        }
        return randomnumbers;
    }

    public void computeAnswer() {
        try {
            List<Integer> answer = makeRandom();
        }catch(IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
