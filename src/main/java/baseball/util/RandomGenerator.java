package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomGenerator {

    public static List<Integer> createRandomIntList(int start, int end, int limitSize) {
        final List<Integer> numberList = new ArrayList<>();
        while (numberList.size() != limitSize) {
            final int randomNumber = Randoms.pickNumberInRange(start, end);
            if (!numberList.contains(randomNumber)) numberList.add(randomNumber);
        }
        return numberList;
    }
}
