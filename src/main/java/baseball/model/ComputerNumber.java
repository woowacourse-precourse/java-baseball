package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ComputerNumber {
    private List<Integer> digits;

    public void setRandomNumber() {
        Set<Integer> digitSet = new HashSet<>();

        while (digitSet.size() < 3) {
            int newNum = getRandomNumber();
            if (digitSet.contains(newNum))
                continue;
            digitSet.add(newNum);
        }

        digits = new ArrayList<>(digitSet);
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }
}
