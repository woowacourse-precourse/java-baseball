package baseball.referee;

import java.util.Arrays;
import java.util.List;

public class Referee {

    public static final String NOTHING = "낫싱";
    public static final String BALL = "볼";
    public static final String STRIKE = "스트라이크";

    public String evaluate(String userBall, String computerBall) {
        List<String> userInputNumbers = Arrays.asList(userBall.split(""));
        List<String> answerNumbers = Arrays.asList(computerBall.split(""));

        int strike = getStrikeCount(userInputNumbers, answerNumbers);
        int ball = getBallCount(userInputNumbers, answerNumbers) - strike;

        if (isNothing(ball, strike)) {
            return NOTHING;
        }

        if (isOnlyBall(strike, ball)) {
            return ball + BALL;
        }

        if (isOnlyStrike(strike, ball)) {
            return strike + STRIKE;
        }

        return ball + BALL + " " + strike + STRIKE;
    }

    private static boolean isOnlyStrike(int strike, int ball) {
        return ball == 0 && strike != 0;
    }

    private static boolean isOnlyBall(int strike, int ball) {
        return ball != 0 && strike == 0;
    }

    private static boolean isNothing(int ball, int strike) {
        return ball == 0 && strike == 0;
    }

    private static int getStrikeCount(List<String> userInputNumbers, List<String> answerNumbers) {
        int count = 0;

        for (int i = 0; i < answerNumbers.size(); i++) {
            if (isSameNumber(userInputNumbers.get(i), answerNumbers.get(i))) {
                count++;
            }
        }

        return count;
    }

    private static int getBallCount(List<String> userInputNumbers, List<String> answerNumbers) {
        int count = 0;

        for (String userInputNumber : userInputNumbers) {
            if (answerNumbers.contains(userInputNumber)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isSameNumber(String userInputNumber, String answerNumber) {
        return answerNumber.equals(userInputNumber);
    }
}
