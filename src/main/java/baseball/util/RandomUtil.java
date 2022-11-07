package baseball.util;

import baseball.model.constants.GameConstants;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RandomUtil {

    private static List<Integer> randomNumbers;

    public RandomUtil() {
        randomNumbers = new ArrayList<>();
    }

    public static List<Integer> pickNumbers() {
        pickWithoutDuplicateNumbers();
        return toIntegerNumber();
    }

    public static void pickWithoutDuplicateNumbers() {
        while (randomNumbers.size() < GameConstants.NUMBER_LENGTH) {
            int num = pickRandomNumber();
            addRandomNumber(num);
        }
    }

    public static void addRandomNumber(int num) {
        if (!randomNumbers.contains(num)) {
            randomNumbers.add(num);
        }
    }

    public static int pickRandomNumber() {
        return Randoms.pickNumberInRange(GameConstants.NUMBER_MIN, GameConstants.NUMBER_MAX);
    }

    public static List<Integer> toIntegerNumber() {
        return randomNumbers.stream().collect(Collectors.toList());
    }

}
