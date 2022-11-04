package baseball.infrastructure.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerRandomNumberGenerator {

    public static List<Integer> generate() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(number)) {
                computerNumber.add(number);
            }
        }
        return computerNumber;
    }

}
