package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    public static BaseballGameNumber generateBaseballGameNumber() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < BaseballGameNumber.NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(BaseballGameNumber.RANGE_START, BaseballGameNumber.RANGE_END);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return new BaseballGameNumber(numbers);
    }
}
