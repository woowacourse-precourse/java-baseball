package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    private final int MAX_LIST_SIZE = 3;

    public List<Integer> generateRandomNumberList() {
        List<Integer> baseballNumbers = new ArrayList<>();
        while (baseballNumbers.size() < MAX_LIST_SIZE) {
            addUniqueBaseballNumber(baseballNumbers);
        }
        return baseballNumbers;
    }

    private void addUniqueBaseballNumber(List<Integer> baseballNumbers) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!baseballNumbers.contains(randomNumber)) {
            baseballNumbers.add(randomNumber);
        }
    }
}
