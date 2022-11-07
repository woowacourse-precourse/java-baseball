package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballGameManager {

    public final static String STRIKE = "스트라이크";
    public final static String BALL = "볼";
    public final static String NOTHING = "낫싱";
    public final static String BLANK = " ";

    private RandomNumberCreator randomNumberCreator = new RandomNumberCreator();
    private int strikeCount;
    private int ballCount;

    public void createRandomNumbers() {
        randomNumberCreator.create();
    }

    public void provideResult(String input) {
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
        if (strikeCount == 0 && ballCount == 0) {
            return NOTHING;
        }

        if (strikeCount == 0 && ballCount != 0) {
            return ballCount + BALL;
        }

        if (strikeCount != 0 && ballCount == 0) {
            return strikeCount + STRIKE;
        }
        return ballCount + BALL + BLANK + strikeCount + STRIKE;
    }
}
