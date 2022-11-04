package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {

    public static List<Integer> getRandomNumbers(int start, int end, int size) {
        List<Integer> randomNumbers = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            randomNumbers.add(getUniqueNumber(start, end, randomNumbers));
        }

        return randomNumbers;
    }

    private static int getUniqueNumber(int start, int end, List<Integer> randomNumbers) {
        int randomNumber = Randoms.pickNumberInRange(start, end);

        while (randomNumbers.contains(randomNumber)) {
            randomNumber = Randoms.pickNumberInRange(start, end);
        }

        return randomNumber;
    }

}
