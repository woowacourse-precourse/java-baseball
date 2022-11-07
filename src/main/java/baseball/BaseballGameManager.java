package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballGameManager {

    private ResultProvider resultProvider = new ResultProvider();
    private RandomNumberCreator randomNumberCreator = new RandomNumberCreator();
    private int strikeCount;
    private int ballCount;

    public void createRandomNumbers() {
        randomNumberCreator.create();
    }

    public void printResult(String input) {
        calculateBallCount(input);
        resultProvider.printResultMessage(strikeCount, ballCount);
    }

    public boolean isGameClear() {
        if (strikeCount == 3) {
            randomNumberCreator.clear();
            return true;
        }
        return false;
    }

    private void calculateBallCount(String input) {
        List<Integer> inputNumbers = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        strikeCount = randomNumberCreator.getStrikeCount(inputNumbers);
        ballCount = randomNumberCreator.getBallCount(inputNumbers);
    }
}
