package baseball;

import static baseball.utils.Constants.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomThreeDigitNumberGenerator {
    public static List<Integer> generate() {
        List<Integer> threeDigitNumber = new ArrayList<>();
        while (threeDigitNumber.size() < RANDOM_NUMBER_LENGTH) {
            int randomNumber = getRandomNumber();
            threeDigitNumber.add(randomNumber);
        }
        return threeDigitNumber;
    }

    private static int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
