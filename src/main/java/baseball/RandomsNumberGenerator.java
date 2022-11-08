package baseball;

import baseball.model.Numbers;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomsNumberGenerator implements NumberGenerator {

    @Override
    public Numbers generateUniqueNumbersInRange(int startNumber, int endNumber, int count) {
        List<Integer> numbers = new ArrayList<>(count);
        while (numbers.size() < count) {
            int number = Randoms.pickNumberInRange(startNumber, endNumber);
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }

        return new Numbers(
                numbers.toArray(Integer[]::new)
        );
    }
}
