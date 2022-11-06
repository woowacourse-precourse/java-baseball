package baseball.domain;

import static baseball.domain.BaseballNumber.BASEBALL_NUMBER_LOWER_BOUND;
import static baseball.domain.BaseballNumber.BASEBALL_NUMBER_UPPER_BOUND;
import static baseball.domain.BaseballNumbers.BASEBALL_NUMBERS_SIZE;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballNumbersFactory {

    public BaseballNumbers generate() {
        List<Integer> baseballs = new ArrayList<>();

        while (baseballs.size() < BASEBALL_NUMBERS_SIZE) {
            addRandomNumber(baseballs);
        }

        return toBaseballNumbers(baseballs);
    }

    private void addRandomNumber(List<Integer> baseballs) {
        int randomNumber = Randoms.pickNumberInRange(BASEBALL_NUMBER_LOWER_BOUND, BASEBALL_NUMBER_UPPER_BOUND);
        if (!baseballs.contains(randomNumber)) {
            baseballs.add(randomNumber);
        }
    }

    private BaseballNumbers toBaseballNumbers(List<Integer> baseballs) {
        return baseballs.stream()
                .map(BaseballNumber::valueOf)
                .collect(collectingAndThen(toList(), BaseballNumbers::new));
    }

    public BaseballNumbers generate(String inputBaseballNumbers) {
        return inputBaseballNumbers.chars()
                .map(Character::getNumericValue)
                .mapToObj(BaseballNumber::valueOf)
                .collect(collectingAndThen(toList(), BaseballNumbers::new));
    }
}
