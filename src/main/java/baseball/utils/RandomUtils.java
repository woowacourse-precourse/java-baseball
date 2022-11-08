package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomUtils {

    public static final Integer RANDOM_NUMBERS_SIZE = 3;
    private static final Integer RANDOM_NUMBER_MIN = 1;
    private static final Integer RANDOM_NUMBER_MAX = 9;

    private RandomUtils() {
    }

    public static List<Integer> pickThreeRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < RANDOM_NUMBERS_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
            checkRandomNumberUnique(randomNumbers, randomNumber);
        }
        return randomNumbers;
    }

    private static void checkRandomNumberUnique(List<Integer> randomNumbers, int randomNumber) {
        if (!randomNumbers.contains(randomNumber)) {
            randomNumbers.add(randomNumber);
        }
    }
}
