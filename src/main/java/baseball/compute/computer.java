package baseball.compute;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class computer {
    public static List<Integer> Answer;
    private static List<Integer> makeRandom() {
        List<Integer> randomnumbers = new ArrayList<>();
        while (randomnumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomnumbers.contains(randomNumber)) {
                randomnumbers.add(randomNumber);
            }
        }
        return randomnumbers;
    }

    public static void isValiableAnswer() {
        try {
            List<Integer> answer = makeRandom();
            Answer = answer;
        }catch(IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
