package baseball;

import java.util.List;

import static baseball.Message.printResultMessage;

public class Result {
    public static Boolean getResult(List<Integer> balls, int[] userBalls) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < userBalls.length; i++) {
            if (userBalls[i] == balls.get(i)) {
                strike += 1;
            } else if (balls.contains(userBalls[i])) {
                ball += 1;
            }
        }
        printResultMessage(ball, strike);
        return !(strike == balls.size());
    }
}
