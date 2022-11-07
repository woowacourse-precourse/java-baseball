package baseball.model;

import baseball.model.constants.BaseballScore;
import baseball.util.RandomUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Computer {

    private List<Integer> numbers;

    public void throwTheBall() {
        RandomUtil randomUtil = new RandomUtil();
        numbers = randomUtil.pickNumbers();
    }

    public Map<BaseballScore, Integer> compare(List<Integer> userNumber) {
        Map<BaseballScore, Integer> result = new HashMap<>() {{
            put(BaseballScore.STRIKE, 0);
            put(BaseballScore.BALL, 0);
            put(BaseballScore.NOTHING, 0);
        }};
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
            return computeContainedNumberScore(number, userNumber);
        }
        return BaseballScore.NOTHING;
    }

    public BaseballScore computeContainedNumberScore(int number, List<Integer> userNumber) {
        if (numbers.indexOf(number) == userNumber.indexOf(number)) {
            return BaseballScore.STRIKE;
        }
        return BaseballScore.BALL;
    }
}
