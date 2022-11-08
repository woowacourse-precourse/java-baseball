package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomGenerator {
    public List<Integer> randomGenerate() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomInt = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomInt)) {
                numbers.add(randomInt);
            }
        }
        return numbers;
    }
}
