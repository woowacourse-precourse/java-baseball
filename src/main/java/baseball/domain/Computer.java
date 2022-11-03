package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

import static baseball.type.BaseballBound.*;
public class Computer {
    private final List<Integer> computerNumbers = createRandomNumbers();

    public Computer() {}

    public List<Integer> createRandomNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < BASEBALL_MAX_SIZE.getValue()) {
            Integer number = Randoms.pickNumberInRange(BASEBALL_NUMBER_MIN.getValue(), BASEBALL_NUMBER_MAX.getValue());
            if (!computerNumbers.contains(number)) {
                computerNumbers.add(number);
            }
        }

        return computerNumbers;
    }
}
