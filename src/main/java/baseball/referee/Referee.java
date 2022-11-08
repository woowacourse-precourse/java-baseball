package baseball.referee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Referee {

    private boolean checkStrikeCondition(int userValueIndex, int computerValueIndex,
                                         List<String> userValue, List<String> computerGeneratedValue) {
        return userValueIndex == computerValueIndex &&
                computerGeneratedValue.get(computerValueIndex)
                        .equals(userValue
                                .get(userValueIndex));
    }

    private boolean checkBallCondition(int userValueIndex, int computerValueIndex,
                                       List<String> userValue, List<String> computerGeneratedValue) {
        return userValueIndex != computerValueIndex &&
                computerGeneratedValue.get(computerValueIndex)
                        .equals(userValue
                                .get(userValueIndex));
    }

    private int countStrike(
            int computerValueIndex, List<String> computerGeneratedValue, List<String> userInputValue) {
        int strikeCount = 0;

        for (int userValueIndex = 0; userValueIndex < 3; userValueIndex++) {
            if (checkStrikeCondition(userValueIndex, computerValueIndex,
                    userInputValue, computerGeneratedValue)) {
                strikeCount += 1;
            }
        }
        return strikeCount;
    }

    private int countBall(
            int computerValueIndex, List<String> computerGeneratedValue, List<String> userInputValue) {
        int ballCount = 0;

        for (int userValueIndex = 0; userValueIndex < 3; userValueIndex++) {
            if (checkBallCondition(userValueIndex, computerValueIndex,
                    userInputValue, computerGeneratedValue)) {
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

    public void sayGameEnded() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
