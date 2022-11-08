package baseball;

import java.util.List;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/08
 */
public class BallCount {
    private int strike;
    private int ball;

    public BallCount() {
    }

    // TODO: stirke 계산
    private void countStrike(List<Integer> answer, List<Integer> userAnswer) {
        this.strike = 0;
        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i).equals(userAnswer.get(i))) {
                strike++;
            }
        }
    }
    // TODO: ball 계산
    private void countBall(List<Integer> answer, List<Integer> userAnswer) {
        this.ball = 0;
        for (int i = 0; i < answer.size(); i++) {
            if (answer.contains(userAnswer.get(i)) && !answer.get(i).equals(userAnswer.get(i))) {
                ball++;
            }
        }
    }
    // TODO: ballcount comment 반환 override toString
    @Override
    public String toString() {
        if (ball == 0 && strike == 0) {
            return "낫싱";
        } else if (ball == 0) {
            return strike  + "스트라이크";
        } else if (strike == 0) {
            return ball + "볼";
        }
        return ball + "볼 " + strike + "스트라이크";
    }
}