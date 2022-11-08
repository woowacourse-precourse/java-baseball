package baseball.repository;

import java.util.*;

public class BaseballResult {
    private final String strike = "strike";
    private final String ball = "ball";
    private Map<String, Integer> result;

    public BaseballResult() {
        result = new HashMap<>();
    }

    public boolean progressJudgement(List<Integer> computerAnswer, List<Integer> playerAnswer) {
        judgeBaseballResult(computerAnswer, playerAnswer);
        showResult();
        return isThreeStrike();
    }

    private void judgeBaseballResult(List<Integer> computerAnswer, List<Integer> playerAnswer) {
        result.put(strike, 0);
        result.put(ball, 0);
        for (int num = 0; num < 3; num++) {
            if (computerAnswer.get(num).equals(playerAnswer.get(num))) {
                result.put(strike, result.get(strike) + 1);
                continue;
            }
            if (computerAnswer.contains(playerAnswer.get(num))) {
                result.put(ball, result.get(ball) + 1);
            }
        }
    }

    private boolean isThreeStrike() {
        final String finishGame = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        final int MAX_STRIKE_COUNT = 3;
        if (result.get(strike) == MAX_STRIKE_COUNT) {
            System.out.println(finishGame);
            return true;
        }
        return false;
    }

    private void showResult() {
        StringBuilder resultString = new StringBuilder();
        if (result.get(ball) > 0) {
            resultString.append(result.get(ball)).append("볼 ");
        }
        if (result.get(strike) > 0) {
            resultString.append(result.get(strike)).append("스트라이크");
        }
        if (result.get(ball) + result.get(strike) == 0) {
            resultString.append("낫싱");
        }
        System.out.println(resultString);
    }

    public Map<String, Integer> getResult() {
        return result;
    }
}
