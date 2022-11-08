package baseball.service.impl;

import baseball.User;
import baseball.service.BaseballGameService;

import java.util.List;

import static baseball.Message.*;

public class BaseballGameServiceImpl implements BaseballGameService {

    private final static int MAX_SIZE = 3;

    public void run(User user) {
        List<Integer> numbers = user.getNumbers();
        List<Integer> answers = user.getAnswers();

        for (int i = 0; i < MAX_SIZE; i++) {
            if (isStrike(numbers.get(i), answers.get(i))) {
                user.addStrike();
            } else if (isBall(numbers.get(i), answers)) {
                user.addBall();
            }
        }
    }

    public String getResultMessage(User user) {
        int ball = user.getBall();
        int strike = user.getStrike();

        if (isStrikeZero(strike) && isBallZero(ball)) {
            return NOT_THING;
        } else if (isStrikeZero(strike)) {
            return ballMessage(ball);
        } else if (isBallZero(ball)) {
            return strikeMessage(strike);
        } else {
            return ballAndStrikeMessage(ball, strike);
        }
    }

    private boolean isStrike(int number, int answer) {
        return number == answer;
    }

    private boolean isBall(int number, List<Integer> answers) {
        return answers.contains(number);
    }

    private boolean isStrikeZero(int strike) {
        return strike == 0;
    }

    private boolean isBallZero(int ball) {
        return ball == 0;
    }
}
