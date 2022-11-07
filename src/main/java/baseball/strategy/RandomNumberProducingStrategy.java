package baseball.strategy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberProducingStrategy implements NumberProducingStrategy {

    private static final int MIN_NUMBER_SIZE = 1;
    private static final int MAX_NUMBER_SIZE = 9;
    private static final int REGULAR_NUMBERS_SIZE = 3;

    @Override
    public List<Integer> produceNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < REGULAR_NUMBERS_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER_SIZE, MAX_NUMBER_SIZE);
            addNonDuplicateNumber(computerNumbers, randomNumber);
        }
        return computerNumbers;
    }

    private static void addNonDuplicateNumber(List<Integer> computerNumbers, int randomNumber) {
        if (!computerNumbers.contains(randomNumber)) {
            computerNumbers.add(randomNumber);
        }
    }
}
