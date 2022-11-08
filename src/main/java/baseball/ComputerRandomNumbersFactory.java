package baseball;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class ComputerRandomNumbersFactory {

    public static final int NUMBER_MAX_LENGTH = 3;
    public static final int MAX_NUMBER = 9;
    public static final int MIN_NUMBER = 1;

    public static List<Integer> createComputerRandomNumber() {
        Set<Integer> computerRandomNumbers = new LinkedHashSet<>();
        while (computerRandomNumbers.size() < NUMBER_MAX_LENGTH) {
            computerRandomNumbers.add(pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
        }
        return new ArrayList<>(computerRandomNumbers);
    }

}
