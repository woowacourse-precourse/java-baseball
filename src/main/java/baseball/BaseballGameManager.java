package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballGameManager {

    public final static String STRIKE = "스트라이크";
    public final static String BALL = "볼";
    public final static String NOTHING = "낫싱";
    public final static String BLANK = " ";

    private NumberAdministrator numberAdministrator = new NumberAdministrator();
    private int strikeCount;
    private int ballCount;

    public void start() {
        numberAdministrator.createRandomNumbers();
    }

    public void provideResult(String input) {
        calculateBallCount(input);
        String message = getResultMessage(strikeCount, ballCount);
        System.out.println(message);
    }

    public boolean isGameClear() {
        if (strikeCount == 3) {
            numberAdministrator.clearRandomNumbers();
            return true;
        }
        return false;
    }

    private void calculateBallCount(String input) {
        List<Integer> inputNumbers = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        strikeCount = numberAdministrator.getStrikeCount(inputNumbers);
        ballCount = numberAdministrator.getBallCount(inputNumbers);
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
