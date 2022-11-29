package baseball.domain.number;

import static baseball.system.Constant.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generate() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < NUMBERS_SIZE) {
            int number = Randoms.pickNumberInRange(NUMBERS_LOWER_BOUND, NUMBERS_UPPER_BOUND);
            if (randomNumbers.contains(number)) {
                continue;
            }
            randomNumbers.add(number);
        }
        return randomNumbers;
    }
}
