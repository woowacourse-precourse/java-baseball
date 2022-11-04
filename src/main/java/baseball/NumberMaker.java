package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberMaker {
    public int makeNumberInRange(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }

    public List<Integer> makeThreeDifferentNumberListInRange(int min, int max) {
        List<Integer> numberList = new ArrayList<>();
        while (numberList.size() < 3) {
            int randomNumber = makeNumberInRange(min, max);
            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }
        return numberList;
    }
}
