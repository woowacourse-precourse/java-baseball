package baseball.game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static baseball.constant.Rule.PICK;

public class Referee {
    private static final String CORRECT_ANSWER = "스트라이크";
    private static final String SIMILAR_ANSWER = "볼 ";
    private static final String WRONG_ANSWER = "낫싱";
    private static final int DEFAULT_VALUE = 0;

    public boolean isPerfectAnswer(List<Integer> targetNumbers, List<Integer> userNumbers) {
        validateNumbersLength(targetNumbers, userNumbers);

        Map<String, Integer> judgeAccuracy = getJudgeAccuracy(targetNumbers, userNumbers);
        System.out.println(shout(judgeAccuracy));

        return judgeAccuracy.getOrDefault(CORRECT_ANSWER, DEFAULT_VALUE) == PICK.getValue();
    }

    private void validateNumbersLength(List<Integer> targetNumbers, List<Integer> userNumbers) {
        if (targetNumbers.size() != PICK.getValue() || userNumbers.size() != PICK.getValue()) {
            throw new IllegalArgumentException("배열의 길이가 " + PICK + "와 같지 않습니다");
        }
    }

    private Map<String, Integer> getJudgeAccuracy(List<Integer> targetNumbers, List<Integer> userNumbers) {
        Map<String, Integer> judgeAccuracy = new HashMap<>();

        for (int idx = 0; idx < targetNumbers.size(); idx++) {
            int targetNumber = targetNumbers.get(idx);
            int userNumber = userNumbers.get(idx);

            if (targetNumber == userNumber) {
                judge(judgeAccuracy, CORRECT_ANSWER);
                continue;
            }

            if (targetNumbers.contains(userNumber)) {
                judge(judgeAccuracy, SIMILAR_ANSWER);
            }
        }

        return judgeAccuracy;
    }

    private void judge(Map<String, Integer> judgeAccuracy, String accuracy) {
        int count = judgeAccuracy.getOrDefault(accuracy, DEFAULT_VALUE);
        judgeAccuracy.put(accuracy, count + 1);
    }

    private String shout(Map<String, Integer> judgeAccuracy) {
        StringBuilder sb = new StringBuilder();

        addToShout(judgeAccuracy, sb, SIMILAR_ANSWER);
        addToShout(judgeAccuracy, sb, CORRECT_ANSWER);

        if (sb.length() > 0) {
            return sb.toString();
        }

        return WRONG_ANSWER;
    }

    private void addToShout(Map<String, Integer> judgeAccuracy, StringBuilder sb, String accuracy) {
        if (judgeAccuracy.containsKey(accuracy)) {
            sb.append(judgeAccuracy.get(accuracy));
            sb.append(accuracy);
        }
    }
}
