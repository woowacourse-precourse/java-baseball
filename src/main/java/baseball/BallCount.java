package baseball;

import java.util.List;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/07
 */
public class BallCount {
    private int strike;
    private int ball;

    private BallCount() {}

    public static String calc(List<Integer> answer, List<Integer> userAnswer) {
        BallCount ballCount = new BallCount();
        ballCount.countStrike(answer, userAnswer);
        ballCount.countBall(answer, userAnswer);
        return ballCount.toString();
    }

    private void countStrike(List<Integer> answer, List<Integer> userAnswer) {
        this.strike = 0;
        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i).equals(userAnswer.get(i))) {
                strike++;
            }
        }
    }

    private void countBall(List<Integer> answer, List<Integer> userAnswer) {
        this.ball = 0;
        for (int i = 0; i < answer.size(); i++) {
            if (answer.contains(userAnswer.get(i)) && !answer.get(i).equals(userAnswer.get(i))) {
                ball++;
            }
        }
    }

    @Override
    public String toString() {
        if (ball == 0 && strike == 0) return "낫싱";
        else if (ball == 0) return strike + "스트라이크";
        else if (strike == 0) return ball + "볼";
        return ball + "볼 " + strike + "스트라이크";
    }
}
