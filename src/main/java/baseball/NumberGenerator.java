package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    public static List<Integer> createNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (computerNumbers.contains(number)) {
                continue;
            }
            computerNumbers.add(number);
        }
        return computerNumbers;
    }
}