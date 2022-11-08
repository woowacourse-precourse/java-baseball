package baseball;

import java.util.Arrays;
import java.util.List;

public class GameScore {
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";

    public static List<Integer> getGameScore(List<Integer> numbers, List<Integer> computers) {
        int strike = 0;
        int ball = 0;

        for (int digit = 0; digit < numbers.size(); digit++) {
            if (numbers.get(digit).equals(computers.get(digit))) {
                strike++;
            } else if (computers.contains(numbers.get(digit))) {
                ball++;
            }
        }

        return Arrays.asList(ball, strike);
    }

    public static String getGameResult(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            return NOTHING;
        } else if (ball != 0 && strike == 0) {
            return ball + BALL;
        } else if (ball == 0) {
            return strike + STRIKE;
        }
        return ball + BALL + " " + strike + STRIKE;
    }
}
