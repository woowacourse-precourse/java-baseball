package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomUtils {

    private RandomUtils() {
    }

    public static List<Integer> pickThreeRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(0, 10);
            checkRandomNumberUnique(randomNumbers, randomNumber);
        }
        return randomNumbers;
    }

    private static void checkRandomNumberUnique(List<Integer> randomNumbers, int randomNumber) {
        if (!randomNumbers.contains(randomNumbers)) {
            randomNumbers.add(randomNumber);
        }
    }
}
