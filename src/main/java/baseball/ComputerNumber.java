package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ComputerNumber {

    private static final int MIN_RANDOM_NUMBER = 1;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int DEFAULT_SIZE_NUMBER = 3;

    public static List<Integer> generateRandomNumber() {
        Set<Integer> computerNumbers = new LinkedHashSet<>();
        while (computerNumbers.size() != DEFAULT_SIZE_NUMBER) {
            computerNumbers.add(Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER));
        }
        return new ArrayList<>(computerNumbers);
    }

}
