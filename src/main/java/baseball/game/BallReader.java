package baseball.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BallReader {
    private static String BALL = "BALL";
    private static String STRIKE = "STRIKE";

    public boolean isFinished(List<Integer> userBall, List<Integer> computerBall) {
        return true;
    }

    public Map<String, Integer> getResult(List<Integer> userBall, List<Integer> computerBall) {
        validateBalls(userBall, computerBall);
        List<String> ballData = evaluateBall(userBall, computerBall);
        return makeResult(ballData);
    }

    private List<String> evaluateBall(List<Integer> userBall, List<Integer> computerBall) {
        List<String> ballData = new ArrayList<>();
        for (int number : userBall) {
            int userIndex = userBall.indexOf(number);
            int computerIndex = computerBall.indexOf(number);
            if (computerIndex == -1) {
                continue;
            }
            if (userIndex == computerIndex) {
                ballData.add(STRIKE);
            }
            if (userIndex != computerIndex) {
                ballData.add(BALL);
            }
        }
        return ballData;
    }

    private Map<String, Integer> makeResult(List<String> ballData) {
        Map<String, Integer> result = new HashMap<>();
        for (String data : ballData) {
            result.computeIfPresent(data, (key, value) -> value + 1);
            result.computeIfAbsent(data, key -> 1);
        }
        return result;
    }

    private void validateBalls(List<Integer> userBall, List<Integer> computerBall) {
        if(userBall.size()!=computerBall.size()){
            throw new IllegalArgumentException("서로 호환 되지 않는 공입니다");
        }
    }
}
