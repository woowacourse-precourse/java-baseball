package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GetNumber {
    private static final int DIGIT_NUMBER = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public List<Integer> computer() {
        List<Integer> computerNumber = new ArrayList<>();

        do {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);

            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        } while (computerNumber.size() != DIGIT_NUMBER);

        return computerNumber;
    }
}
