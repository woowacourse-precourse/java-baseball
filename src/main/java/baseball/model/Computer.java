package baseball.model;

import baseball.BaseballScore;
import baseball.util.RandomUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Computer {

    private List<Integer> numbers;

    public void throwTheBall() {
        numbers = RandomUtil.pickNumbers();
    }

    public Map<BaseballScore, Integer> compare(List<Integer> userNumber) {
        Map<BaseballScore, Integer> result = new HashMap<>() {
            {
                put(BaseballScore.STRIKE, 0);
                put(BaseballScore.BALL, 0);
                put(BaseballScore.NOTHING, 0);
            }
        };
        computeScoreCount(userNumber, result);
        return result;
    }

    public void computeScoreCount(List<Integer> userNumber, Map<BaseballScore, Integer> result) {
        for (int number : userNumber) {
            BaseballScore score = computeNumberScore(number, userNumber);
            result.put(score, result.get(score) + 1);
        }
    }

    public BaseballScore computeNumberScore(int number, List<Integer> userNumber) {
        if (numbers.contains(number)) {
            if (numbers.indexOf(number) == userNumber.indexOf(number)) {
                return BaseballScore.STRIKE;
            }
            return BaseballScore.BALL;
        }
        return BaseballScore.NOTHING;
    }
}
