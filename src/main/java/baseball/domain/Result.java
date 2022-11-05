package baseball.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Result {
    private final List<Integer> answer;
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
            put("ball", 0);
            put("strike", 0);
        }};
    }

    private void countScore(List<Integer> userAnswer, Integer index) {
        Integer currentAnswer = answer.get(index);
        Integer currentUserAnswer = userAnswer.get(index);

        if (isStrike(currentAnswer, currentUserAnswer)) {
            resultMap.put("strike", resultMap.get("strike") + 1);
        }

        if (isBall(currentAnswer, currentUserAnswer)) {
            resultMap.put("ball", resultMap.get("ball") + 1);
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
