package baseball.referee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Referee {

    public int strike(int computerValueIndex, List<String> computerGeneratedValue, List<String> userInputValue) {
        int strikeCount = 0;

        for (int userValueIndex = 0; userValueIndex < 3; userValueIndex++) {
            if (userValueIndex == computerValueIndex &&
                    computerGeneratedValue.get(computerValueIndex).equals(userInputValue.get(userValueIndex))) {
                strikeCount += 1;
            }
        }

        return strikeCount;
    }

    public int ball(int computerValueIndex, List<String> computerGeneratedValue, List<String> userInputValue) {
        int ballCount = 0;

        for (int userValueIndex = 0; userValueIndex < 3; userValueIndex++) {
            if (userValueIndex != computerValueIndex &&
                    computerGeneratedValue.get(computerValueIndex).equals(userInputValue.get(userValueIndex))) {
                ballCount += 1;
            }
        }
        return ballCount;
    }

    public Map<String, Integer> judgement(List<String> computerGeneratedValue, List<String> userInputValue) {

        int strikeCount = 0;
        int ballCount = 0;

        if (computerGeneratedValue.equals(userInputValue)) {
            Map<String, Integer> strikeBallCount = new HashMap<>();
            strikeBallCount.put("strikeCount", 3);
            strikeBallCount.put("ballCount", 3);

            return strikeBallCount;
        }

        Map<String, Integer> strikeBallCount = new HashMap<>();

        for (int computerValueIndex = 0; computerValueIndex < 3; computerValueIndex++) {
            strikeCount += strike(computerValueIndex, computerGeneratedValue, userInputValue);
            ballCount += ball(computerValueIndex, computerGeneratedValue, userInputValue);
        }

        strikeBallCount.put("strikeCount", strikeCount);
        strikeBallCount.put("ballCount", ballCount);

        return strikeBallCount;
    }

    public void say(Map<String, Integer> judgement) {
        if (judgement.get("strikeCount") == 3) {
            System.out.println(judgement.get("strikeCount") + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else if (judgement.get("strikeCount") == 0 && judgement.get("ballCount") == 0) {
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
