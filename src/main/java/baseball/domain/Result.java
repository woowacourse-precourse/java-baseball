package baseball.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import baseball.utils.ScoreType;

public class Result {
    private final List<Integer> answer;
    private final String STRIKE = ScoreType.STRIKE.getLabel();
    private final String BALL = ScoreType.BALL.getLabel();
    private Map<String, Integer> resultMap;

    public Result(List<Integer> answer) {
        this.answer = answer;
    }

    public Map<String, Integer> getResult(List<Integer> userAnswer) {
        initializeResultMap();
        for (int index = 0; index < userAnswer.size(); index++) {
            countScore(userAnswer, index);
        }
        return resultMap;
    }

    private void initializeResultMap() {
        this.resultMap = new HashMap<>() {{
            put(STRIKE, 0);
            put(BALL, 0);
        }};
    }

    private void countScore(List<Integer> userAnswer, Integer index) {
        Integer currentAnswer = answer.get(index);
        Integer currentUserAnswer = userAnswer.get(index);

        if (isStrike(currentAnswer, currentUserAnswer)) {
            resultMap.put(STRIKE, resultMap.get(STRIKE) + 1);
        }

        if (isBall(currentAnswer, currentUserAnswer)) {
            resultMap.put(BALL, resultMap.get(BALL) + 1);
        }
    }

    private boolean isBall(Integer answerInt, Integer userAnswerInt) {
        return answer.contains(userAnswerInt)
                && !Objects.equals(answerInt, userAnswerInt);
    }

    private boolean isStrike(Integer answerInt, Integer userAnswerInt) {
        return Objects.equals(answerInt, userAnswerInt);
    }
}
