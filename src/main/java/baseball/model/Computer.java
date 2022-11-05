package baseball.model;

import baseball.BaseballScore;
import baseball.util.RandomUtil;
import java.util.List;

public class Computer {

    private List<Integer> ballNumber;

    public void throwTheBall() {
        ballNumber = RandomUtil.pickNumbers();
    }

    public BaseballScore computeNumberScore(int number, List<Integer> batNumber) {
        if (ballNumber.contains(number)) {
            if (ballNumber.indexOf(number) == batNumber.indexOf(number)) {
                return BaseballScore.STRIKE;
            }
            return BaseballScore.BALL;
        }
        return BaseballScore.NOTHING;
    }
}
