package baseball.service;

import baseball.model.BallCount;

import java.util.List;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/08
 */
public class BallCountService {
    public static BallCount calc(List<Integer> answer, List<Integer> userAnswer) {
        int strike = countStrike(answer, userAnswer);
        int ball = countBall(answer, userAnswer);
        return new BallCount(strike, ball);
    }

    private static int countStrike(List<Integer> answer, List<Integer> userAnswer) {
        int strike = 0;
        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i).equals(userAnswer.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    private static int countBall(List<Integer> answer, List<Integer> userAnswer) {
        int ball = 0;
        for (int i = 0; i < answer.size(); i++) {
            if (answer.contains(userAnswer.get(i)) && !answer.get(i).equals(userAnswer.get(i))) {
                ball++;
            }
        }
        return ball;
    }

}
