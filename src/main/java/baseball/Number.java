package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Number {

    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 9;
    private static final int CNT_NUMBER = 3;

    public Number() {
    }

    public List<Integer> generateRandomNumber() {
        List<Integer> computerNumbers = new ArrayList<>();

        while (computerNumbers.size() < CNT_NUMBER) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);

            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }

        return computerNumbers;
    }
}