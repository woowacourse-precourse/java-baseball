package baseball.model;

import baseball.BaseballScore;
import baseball.util.RandomUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Computer {

    private List<Integer> ballNumber;

    public void throwTheBall() {
        ballNumber = RandomUtil.pickNumbers();
    }

    public Map<BaseballScore, Integer> compare(List<Integer> batNumber) {
        Map<BaseballScore, Integer> result = new HashMap<>() {
            {
                put(BaseballScore.STRIKE, 0);
                put(BaseballScore.BALL, 0);
                put(BaseballScore.NOTHING, 0);
            }
        };
        computeScoreCount(batNumber, result);
        return result;
    }

    public void computeScoreCount(List<Integer> batNumber, Map<BaseballScore, Integer> result) {
        for (int number : batNumber) {
            BaseballScore score = computeNumberScore(number, batNumber);
            result.put(score, result.get(score) + 1);
        }
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
