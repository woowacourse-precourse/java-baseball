package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BaseballGameManager {

    public final static int NUMBER_COUNT_TO_CREATED = 3;

    private ResultProvider resultProvider = new ResultProvider();
    private List<Integer> randomNumbers = new ArrayList<>();
    private int strikeCount;
    private int ballCount;

    public void createRandomNumbers() {
        while (randomNumbers.size() < NUMBER_COUNT_TO_CREATED) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
    }

    public void printResult(String input) {
        calculateBallCount(input);
        resultProvider.printResultMessage(strikeCount, ballCount);
    }

    public boolean isGameClear() {
        if (strikeCount == 3) {
            randomNumbers.clear();
            return true;
        }
        return false;
    }

    private void calculateBallCount(String input) {
        List<Integer> inputNumbers = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        strikeCount = (int) IntStream.range(0, 3)
                .filter(idx -> isStrike(idx, inputNumbers))
                .count();

        ballCount = (int) IntStream.range(0, 3)
                .filter(idx -> randomNumbers.contains(inputNumbers.get(idx)))
                .filter(idx -> !isStrike(idx, inputNumbers))
                .count();
    }

    private boolean isStrike(int idx, List<Integer> inputNumbers) {
        return randomNumbers.get(idx).equals(inputNumbers.get(idx));
    }
}
