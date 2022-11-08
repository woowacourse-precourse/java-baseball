package baseball.util;

import static baseball.constant.SystemValue.BALL_MAXIMUM_VALUE;
import static baseball.constant.SystemValue.BALL_MINIMUM_VALUE;
import static baseball.constant.SystemValue.COMPUTER_BALLS_SIZE;
import static baseball.constant.SystemValue.CONTINUE_GAME;
import static baseball.constant.SystemValue.STOP_GAME;

import java.util.List;

public class InputValidator {

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
