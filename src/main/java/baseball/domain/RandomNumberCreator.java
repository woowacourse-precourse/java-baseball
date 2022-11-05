package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberCreator {

    public static final int CRITERION_NUMBER_SIZE = 3;
    public static final int MINIMUM_NUMBER = 1;
    public static final int MAX_NUMBER = 9;

    public static int createRandomNumber() {
        return Randoms.pickNumberInRange(MINIMUM_NUMBER, MAX_NUMBER);
    }

    public static List<Integer> createRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < CRITERION_NUMBER_SIZE) {
            addUniqueNumber(randomNumbers, createRandomNumber());
        }
        return randomNumbers;
    }

    private static void addUniqueNumber(List<Integer> randomNumbers, int randomNumber) {
        if (!randomNumbers.contains(randomNumber)) {
            randomNumbers.add(randomNumber);
        }
    }
}
