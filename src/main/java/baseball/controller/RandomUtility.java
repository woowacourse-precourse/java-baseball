package baseball.controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomUtility {
    private static final int BASEBALL_GAME_NUMBER_LENGTH = 3;
    private static final int BASEBALL_GAME_RANDOM_RANGE_START = 1;
    private static final int BASEBALL_GAME_RANDOM_RANGE_END = 9;

    public List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();

        for (int i = 0; i < BASEBALL_GAME_NUMBER_LENGTH; i++) {
            randomNumbers.add(generateRandomNumber(randomNumbers));
        }

        return randomNumbers;
    }

    private int generateRandomNumber(List<Integer> randomNumbers) {
        while (true) {
            int randomNumber = Randoms.pickNumberInRange(BASEBALL_GAME_RANDOM_RANGE_START,
                    BASEBALL_GAME_RANDOM_RANGE_END);
            System.out.println("randomNumber : " + randomNumber);

            if (isDifferentNumber(randomNumbers, randomNumber)) {
                return randomNumber;
            }
        }
    }

    private boolean isDifferentNumber(List<Integer> randomNumbers, int randomNumber) {
        return !randomNumbers.contains(randomNumber);
    }
}
