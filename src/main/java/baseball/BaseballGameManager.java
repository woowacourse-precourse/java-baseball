package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballGameManager {

    private RandomNumberCreator randomNumberCreator = new RandomNumberCreator();
    private int strikeCount;
    private int ballCount;

    public void createRandomNumbers() {
        randomNumberCreator.create();
    }

    public void printResult(String input) {
        calculateBallCount(input);
        String message = getResultMessage(strikeCount, ballCount);
        System.out.println(message);
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

    private String getResultMessage(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount != 0) {
            return ballCount + "볼";
        }

        if (strikeCount != 0 && ballCount == 0) {
            return strikeCount + "스트라이크";
        }

        if (strikeCount != 0 && ballCount != 0) {
            return ballCount + "볼 " + strikeCount + "스트라이크";
        }

        return "낫싱";
    }
}
