package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RandomUtil {
    public static final int NUMBER_LENGTH = 3;
    public static final int NUMBER_MIN = 1;
    public static final int NUMBER_MAX = 9;

    public static List<Integer> pickNumbers() {
        Set<Integer> randomNumbers = new HashSet<>();
        pickWithoutDuplicateNumbers(randomNumbers);
        return toIntegerNumber(randomNumbers);
    }

    public static void pickWithoutDuplicateNumbers(Set<Integer> randomNumbers) {
        while (randomNumbers.size() < NUMBER_LENGTH) {
            int num = pickRandomNumber();
            if (!randomNumbers.contains(num)) {
                randomNumbers.add(num);
            }
        }
    }

    public static int pickRandomNumber() {
        return Randoms.pickNumberInRange(NUMBER_MIN, NUMBER_MAX);
    }

    public static List<Integer> toIntegerNumber(Set<Integer> randomNumbers) {
        return randomNumbers.stream().collect(Collectors.toList());
    }

}
