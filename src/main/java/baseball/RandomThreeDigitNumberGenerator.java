package baseball;

import static baseball.utils.Constants.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RandomThreeDigitNumberGenerator {
    public static List<Integer> generate() {
        Set<Integer> threeDigitNumber = new LinkedHashSet<>();
        while (threeDigitNumber.size() < RANDOM_NUMBER_LENGTH) {
            int randomNumber = getRandomNumber();
            threeDigitNumber.add(randomNumber);
        }
        return new ArrayList<>(threeDigitNumber);
    }

    private static int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
