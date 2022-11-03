package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomNumberGenerator {

    public static final int MAX_SIZE_OF_NUMBERS = 3;

    public static final int MIN_VALUE_OF_NUMBER = 1;
    public static final int MAX_VALUE_OF_NUMBER = 9;

    public List<Integer> generate() {
        Set<Integer> randomNumbers = new HashSet<>();

        while (isNotFull(randomNumbers)) {
            int randomNumber = generateRandomNumber();

            randomNumbers.add(randomNumber);
        }

        return new ArrayList<>(randomNumbers);
    }

    private boolean isNotFull(Set<Integer> randomNumbers) {
        return randomNumbers.size() < MAX_SIZE_OF_NUMBERS;
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_VALUE_OF_NUMBER, MAX_VALUE_OF_NUMBER);
    }
}
