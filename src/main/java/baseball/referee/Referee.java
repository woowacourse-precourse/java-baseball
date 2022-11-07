package baseball.referee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Referee {

    public boolean checkStrikeCondition(int userValueIndex, int computerValueIndex,
                                        List<String> userValue, List<String> computerGeneratedValue) {
        return userValueIndex == computerValueIndex &&
                computerGeneratedValue.get(computerValueIndex)
                        .equals(userValue
                                .get(userValueIndex));
    }

    public boolean checkBallCondition(int userValueIndex, int computerValueIndex,
                                      List<String> userValue, List<String> computerGeneratedValue) {
        return userValueIndex != computerValueIndex &&
                computerGeneratedValue.get(computerValueIndex)
                        .equals(userValue
                                .get(userValueIndex));
    }

    public int countStrike(int computerValueIndex, List<String> computerGeneratedValue, List<String> userValue) {
        int strikeCount = 0;

        for (int userValueIndex = 0; userValueIndex < 3; userValueIndex++) {
            if (checkStrikeCondition(userValueIndex, computerValueIndex, userValue, computerGeneratedValue)) {
                strikeCount += 1;
            }
        }
        return strikeCount;
    }

    public int countBall(int computerValueIndex, List<String> computerGeneratedValue, List<String> userValue) {
        int ballCount = 0;

        for (int userValueIndex = 0; userValueIndex < 3; userValueIndex++) {
            if (checkBallCondition(userValueIndex, computerValueIndex, userValue, computerGeneratedValue)) {
                ballCount += 1;
            }
        }
        return ballCount;
    }

    public Map<String, Integer> judgement(List<String> computerGeneratedValue, List<String> userInputValue) {

        if (computerGeneratedValue.equals(userInputValue)) {
            Map<String, Integer> strikeBallCount = new HashMap<>();
            strikeBallCount.put("strikeCount", 3);
            strikeBallCount.put("ballCount", 3);

            return strikeBallCount;
        }

        int strikeCount = 0;
        int ballCount = 0;

        for (int computerValueIndex = 0; computerValueIndex < 3; computerValueIndex++) {
            strikeCount += countStrike(computerValueIndex, computerGeneratedValue, userInputValue);
            ballCount += countBall(computerValueIndex, computerGeneratedValue, userInputValue);
        }

        Map<String, Integer> strikeBallCount = new HashMap<>();
        strikeBallCount.put("strikeCount", strikeCount);
        strikeBallCount.put("ballCount", ballCount);

        return strikeBallCount;
    }

    public void sayJudgement(Map<String, Integer> judgement) {
        if (judgement.get("strikeCount") == 0 && judgement.get("ballCount") == 0) {
            System.out.println("낫싱");
        } else if (judgement.get("strikeCount") != 0 && judgement.get("ballCount") == 0) {
            System.out.println(judgement.get("strikeCount") + "스트라이크");
        } else if (judgement.get("strikeCount") == 0 && judgement.get("ballCount") != 0) {
            System.out.println(judgement.get("ballCount") + "볼");
        } else if (judgement.get("strikeCount") != 0 && judgement.get("ballCount") != 0) {
            System.out.println(judgement.get("ballCount") + "볼 " + judgement.get("strikeCount") + "스트라이크");
        }
    }
}
