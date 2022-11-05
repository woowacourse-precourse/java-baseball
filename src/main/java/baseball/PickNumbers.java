package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.Constant.*;

public class PickNumbers {


    List<Integer> pickNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < NUMBERS_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE_NUMBER, MAX_RANGE_NUMBER);
            if (! numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
}
