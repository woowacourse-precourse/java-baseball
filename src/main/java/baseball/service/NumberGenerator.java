package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberGenerator {
    private static final int PICK_COUNT = 3;

    public List<Integer> createRandomNumbers() {
        Set<Integer> randomNumbers = new HashSet<>();
        while (randomNumbers.size() < PICK_COUNT) {
            randomNumbers.add(Randoms.pickNumberInRange(1, 9));
        }

        return new ArrayList<>(randomNumbers);
    }
}