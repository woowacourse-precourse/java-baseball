package baseball;

import java.util.List;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/07
 */
public class BallCount {
    private int strike;
    private int ball;

    public BallCount(List<Integer> answer, List<Integer> inputAnswer) {

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
    // TODO: ballcount comment 반환 override toString
}
