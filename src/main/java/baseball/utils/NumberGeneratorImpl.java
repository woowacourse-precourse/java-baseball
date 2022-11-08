package baseball.utils;

import static baseball.BaseBallGame.GAME_NUMBER_LENGTH;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberGeneratorImpl implements NumberGenerator {

    private static final int DIGIT_LOWER_BOUND = 1;
    private static final int DIGIT_UPPER_BOUND = 9;

    @Override
    public List<Integer> generateNumber() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < GAME_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(DIGIT_LOWER_BOUND, DIGIT_UPPER_BOUND);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
}
