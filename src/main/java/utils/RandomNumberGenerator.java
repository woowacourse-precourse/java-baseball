package utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    private final static int RANDOM_NUMBER_LENGTH = 3;
    private static final int RANDOM_NUMBER_RANGE_MIN = 1;
    private static final int RANDOM_NUMBER_RANGE_MAX = 9;

    private RandomNumberGenerator() {}

    public static List<Integer> generate() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < RANDOM_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_RANGE_MIN, RANDOM_NUMBER_RANGE_MAX);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
