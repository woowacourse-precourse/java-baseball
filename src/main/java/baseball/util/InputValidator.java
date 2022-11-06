package baseball.util;

import java.util.List;

public class InputValidator {

    public static final int CONTINUE_GAME = 1;
    public static final int STOP_GAME = 2;
    public static final int COMPUTER_BALLS_SIZE = 3;

    static final int BALL_MINIMUM_VALUE = 1;
    static final int BALL_MAXIMUM_VALUE = 9;

    public static boolean checkPlayerBall(List<Integer> playerBalls) {
        return isSizeValid(playerBalls) && isRangeValid(playerBalls) && isDistinct(playerBalls);
    }

    public static boolean isSizeValid(List<Integer> playerBalls) {
        return playerBalls.size() == COMPUTER_BALLS_SIZE;
    }

    public static boolean isRangeValid(List<Integer> playerBalls) {
        return playerBalls.stream()
                .filter(number -> BALL_MINIMUM_VALUE <= number && number <= BALL_MAXIMUM_VALUE)
                .count() == COMPUTER_BALLS_SIZE;
    }

    public static boolean isDistinct(List<Integer> playerBalls) {
        return playerBalls.stream()
                .distinct()
                .count() == COMPUTER_BALLS_SIZE;
    }

    public static boolean checkProgressAnswer(String answer) {
        return isAnswerValid(answer);
    }

    public static boolean isAnswerValid(String answer) {
        return answer.equals(Integer.toString(CONTINUE_GAME)) || answer.equals(Integer.toString(STOP_GAME));
    }
}
