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
}