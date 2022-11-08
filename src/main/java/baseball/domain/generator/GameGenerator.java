package baseball.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameGenerator {

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 9;
    private static final int NUMBER_OF_DIGIT = 3;

    public static List<Integer> createGame() {
        Set<Integer> number = new HashSet<>();
        while (number.size() < NUMBER_OF_DIGIT) {
            number.add(Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER));
        }

        return new ArrayList<>(number);
    }
}
