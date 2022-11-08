package baseball.game.number;

import java.util.List;

public class Calculator {
    private static final int TOTAL_COUNT = 3;

    public static Score scoreCalculator(List<Integer> answer, List<Integer> userInput) {
        Score userScore = new Score();
        int strike = countStrike(answer, userInput);
        int ball = countBall(answer, userInput) - strike;
        int out = countOut(strike, ball);
        userScore.update(strike, ball, out);

        return userScore;
    }
}
