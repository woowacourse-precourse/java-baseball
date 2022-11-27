package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseBallRandomNumbersGenerator implements BaseballNumbersGenerator {

    private static final int NUMBERS_SIZE = 3;
    private static final int RANDOM_LOWER_INCLUSIVE = 1;
    private static final int RANDOM_UPPER_INCLUSIVE = 9;

    @Override
    public List<Integer> generate() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() != NUMBERS_SIZE) {
            int number = Randoms.pickNumberInRange(RANDOM_LOWER_INCLUSIVE, RANDOM_UPPER_INCLUSIVE);
            if (randomNumbers.contains(number)) {
                continue;
            }
            randomNumbers.add(number);
        }
        return randomNumbers;
    }
}
