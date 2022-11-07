package baseball.gamelogic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballGameManager {

    public final static String STRIKE = "스트라이크";
    public final static String BALL = "볼";
    public final static String NOTHING = "낫싱";
    public final static String BLANK = " ";

    public final static int FULL_COUNT = 3;
    public final static int NO_COUNT = 0;

    private NumberAdministrator numberAdministrator = new NumberAdministrator();
    private int strikeCount;
    private int ballCount;

    public void setup() {
        numberAdministrator.createRandomNumbers();
    }

    public void provideResult(String input) {
        calculateBallCount(input);
        System.out.println(getResultMessage(strikeCount, ballCount));
    }

    public boolean isGameClear() {
        if (strikeCount == FULL_COUNT) {
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
        if (strikeCount == NO_COUNT && ballCount == NO_COUNT) {
            return NOTHING;
        }

        if (strikeCount == NO_COUNT) {
            return ballCount + BALL;
        }

        if (ballCount == NO_COUNT) {
            return strikeCount + STRIKE;
        }
        return ballCount + BALL + BLANK + strikeCount + STRIKE;
    }
}
