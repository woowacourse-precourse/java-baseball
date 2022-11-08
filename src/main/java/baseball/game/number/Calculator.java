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

    private static int countStrike(List<Integer> answer, List<Integer> userInput) {
        int strike = 0;
        for (int index = 0; index < TOTAL_COUNT; index++) {
            strike = checkStrike(answer.get(index), userInput.get(index), strike);
        }
        return strike;
    }

    private static int checkStrike(int answerNumber, int userNumber, int strike) {
        if (answerNumber == userNumber) {
            strike++;
        }
        return strike;
    }

    private static int countBall(List<Integer> answer, List<Integer> userInput) {
        int ball = 0;
        for (int userNumber : userInput) {
            ball = checkBall(answer, userNumber, ball);
        }
        return ball;
    }

    private static int countOut(int strike, int ball) {
        return TOTAL_COUNT - strike - ball;
    }

    public static int checkBall(List<Integer> answer, int userNumber, int ball) {
        for (int answerNumber : answer) {
            if (userNumber == answerNumber) {
                ball++;
            }
        }
        return ball;
    }
}
