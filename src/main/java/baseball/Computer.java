package computer;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    static List<Integer> randomNumbers;

    static final int MAX_SIZE = 3;
    static final int MIN_NUM = 1;
    static final int MAX_NUM = 9;

    public static void resetRandomNumbers() {
        randomNumbers = new ArrayList<>();
    }

    public static List<Integer> pickRandomNumbers() {
        resetRandomNumbers();
        while (randomNumbers.size() < MAX_SIZE) {
            int randomNum = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
            if (!randomNumbers.contains(randomNum)) {
                randomNumbers.add(randomNum);
            }
        }
        return randomNumbers;
    }
}
