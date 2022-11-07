package baseball.gamelogic;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class NumberAdministrator {

    public final static int NUMBER_COUNT_TO_CREATED = 3;

    List<Integer> randomNumbers = new ArrayList<>();

    public void createRandomNumbers() {
        while (randomNumbers.size() < NUMBER_COUNT_TO_CREATED) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
    }

    public void clearRandomNumbers() {
        randomNumbers.clear();
    }

    public int getStrikeCount(List<Integer> inputNumbers) {
        return (int) IntStream.range(0, 3)
                .filter(idx -> isStrike(idx, inputNumbers))
                .count();
    }

    public int getBallCount(List<Integer> inputNumbers) {
        return (int) IntStream.range(0, 3)
                .filter(idx -> randomNumbers.contains(inputNumbers.get(idx)))
                .filter(idx -> !isStrike(idx, inputNumbers))
                .count();
    }

    private boolean isStrike(int idx, List<Integer> inputNumbers) {
        return randomNumbers.get(idx).equals(inputNumbers.get(idx));
    }
}
