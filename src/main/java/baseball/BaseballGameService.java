package baseball;

import java.util.List;

public class BaseballGameService {

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
        if (isStrikeZero(user.getStrike()) && isBallZero(user.getBall())) {
            return "낫싱";
        } else if (isStrikeZero(user.getStrike())) {
            return user.getBall() + "볼";
        } else if (isBallZero(user.getBall())) {
            return user.getStrike() + "스트라이크";
        } else {
            return user.getBall() + "볼 " + user.getStrike() + "스트라이크";
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
