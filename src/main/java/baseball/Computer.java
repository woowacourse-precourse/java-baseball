package baseball;

import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Computer {

    private static final int GENERATE_COUNT = 3;

    public Numbers generateNumbers(int startInclusive, int endInclusive) {
        return new Numbers(generateRandomNumbers(startInclusive, endInclusive));
    }

    private List<Integer> generateRandomNumbers(int startInclusive, int endInclusive) {
        Set<Integer> randomNumbers = new LinkedHashSet<>();
        while (randomNumbers.size() != GENERATE_COUNT) {
            randomNumbers.add(pickNumberInRange(startInclusive, endInclusive));
        }
        return new ArrayList<>(randomNumbers);
    }
}
