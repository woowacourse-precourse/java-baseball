package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generate() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() != Constants.NUMBERS_SIZE) {
            int number = Randoms.pickNumberInRange(Constants.NUMBERS_LOWER_BOUND, Constants.NUMBERS_UPPER_BOUND);
            if (randomNumbers.contains(number)) {
                continue;
            }
            randomNumbers.add(number);
        }
        return randomNumbers;
    }
}
