package baseball;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class ComputerRandomNumbersFactory {

    private static final int NUMBER_MAX_LENGTH = 3;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MIN_RANDOM_NUMBER = 1;

    public static List<Integer> createComputerRandomNumber() {
        Set<Integer> computerRandomNumbers = new LinkedHashSet<>();
        while (computerRandomNumbers.size() < NUMBER_MAX_LENGTH) {
            computerRandomNumbers.add(pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER));
        }
        return new ArrayList<>(computerRandomNumbers);
    }

}
