package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private static final int SIZE = 3;

    public static List<Integer> generateNumbers() {

        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() != SIZE) {
            int number = Randoms.pickNumberInRange(1, 9);

            if (!randomNumbers.contains(number))
                randomNumbers.add(number);
        }

        return randomNumbers;
    }
}
