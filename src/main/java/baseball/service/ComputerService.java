package baseball.service;

import static baseball.Constants.MAX_RANGE;
import static baseball.Constants.MIN_RANGE;
import static baseball.Constants.TRIPLE_DIGITS;

import baseball.domain.Computer;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerService {

    public Computer createAnswer() {
        return new Computer(generateNonDuplicateNumbers());
    }

    public List<Integer> generateNonDuplicateNumbers() {
        List<Integer> result = new ArrayList<>();

        while (result.size() < TRIPLE_DIGITS) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
            if (!result.contains(randomNumber)) {
                result.add(randomNumber);
            }
        }

        return result;
    }
}
