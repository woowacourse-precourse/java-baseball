package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumber {
    public static List<Integer> create() {
        List<Integer> baseballNumber = new ArrayList<>();

        while (baseballNumber.size() < 3) {
            int digit = Randoms.pickNumberInRange(1, 9);
            if (!baseballNumber.contains(digit)) {
                baseballNumber.add(digit);
            }
        }

        return baseballNumber;
    }
}
