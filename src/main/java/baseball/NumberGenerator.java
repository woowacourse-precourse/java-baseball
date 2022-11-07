package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    private static final int LENGTH = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    List<Integer> baseballNumbers;

    public List<Integer> generateRandomNumber() {
        this.baseballNumbers = new ArrayList<>();
        for (int i = 0; i < LENGTH; i++) {
            baseballNumbers.add(getUniqueNumber());
        }
        return baseballNumbers;
    }

    private int getUniqueNumber() {
        while (true) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!baseballNumbers.contains(randomNumber)) {
                return randomNumber;
            }
        }
    }

}
