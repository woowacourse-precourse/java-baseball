package util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomUniqueNumber {
    private static final int MINIMUM_RANDOM_NUMBER_RANGE = 1;
    private static final int MAXIMUM_RANDOM_NUMBER_RANGE = 9;

    public static List<Integer> getRandomUniqueNumbers(int size) {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < size) {
            int randomNumber = Randoms.pickNumberInRange(MINIMUM_RANDOM_NUMBER_RANGE, MAXIMUM_RANDOM_NUMBER_RANGE);

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }
}
