package baseball.domain;

import static java.util.stream.Collectors.toList;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballNumberFactory {
    private static final int BASEBALL_NUMBER_LOWER_BOUND = 1;
    private static final int BASEBALL_NUMBER_UPPER_BOUND = 9;
    private static final int BASEBALL_NUMBERS_SIZE = 3;

    public List<BaseballNumber> generate() {
        List<Integer> baseballs = new ArrayList<>();

        while (baseballs.size() < BASEBALL_NUMBERS_SIZE) {
            addRandomNumber(baseballs);
        }

        return mapToBaseballNumber(baseballs);
    }

    private void addRandomNumber(List<Integer> baseballs) {
        int randomNumber = Randoms.pickNumberInRange(BASEBALL_NUMBER_LOWER_BOUND, BASEBALL_NUMBER_UPPER_BOUND);
        if (!baseballs.contains(randomNumber)) {
            baseballs.add(randomNumber);
        }
    }

    private List<BaseballNumber> mapToBaseballNumber(List<Integer> baseballs) {
        return baseballs.stream()
                .map(BaseballNumber::valueOf)
                .collect(toList());
    }
}
