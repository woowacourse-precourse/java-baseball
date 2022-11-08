package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class NumberGenerator {
    public StringBuilder setRandomNumber() {
        Set<Integer> digitSet = new HashSet<>();
        StringBuilder uniqueNumber = new StringBuilder();

        while (digitSet.size() < 3) {
            int newNum = getRandomNumber();
            if (digitSet.contains(newNum))
                continue;
            digitSet.add(newNum);
        }

        for (int num : digitSet)
            uniqueNumber.append(num);
        return uniqueNumber;
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }
}
