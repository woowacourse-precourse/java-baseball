package baseball.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BallReader {
    private static String BALL = "BALL";
    private static String STRIKE = "STRIKE";
    private int requiredStrikes;

    public BallReader() {
        this.requiredStrikes = 3;
    }

    public boolean isFinished(Ball userBall, Ball computerBall) {
        Map<String, Integer> result = getResult(userBall, computerBall);
        if (result.get(STRIKE) == null) {
            return false;
        }
        return result.get(STRIKE) == requiredStrikes;
    }

    public Map<String, Integer> getResult(Ball userBall, Ball computerBall) {
        validateBalls(userBall, computerBall);
        List<String> ballData = evaluateBall(userBall, computerBall);
        return makeResult(ballData);
    }

    private List<String> evaluateBall(Ball userBall, Ball computerBall) {
        final int noNumberInComputer = -1;
        List<Integer> userBallData = userBall.getBallData();
        List<Integer> computerBallData = computerBall.getBallData();
        List<String> strikeAndBallResult = new ArrayList<>();
        for (int number : userBallData) {
            int userIndex = userBallData.indexOf(number);
            int computerIndex = computerBallData.indexOf(number);
            if (userIndex == computerIndex) {
                strikeAndBallResult.add(STRIKE);
            }
            if (userIndex != computerIndex && computerIndex != noNumberInComputer) {
                strikeAndBallResult.add(BALL);
            }
        }
        return strikeAndBallResult;
    }

    private Map<String, Integer> makeResult(List<String> ballData) {
        Map<String, Integer> result = new HashMap<>();
        for (String data : ballData) {
            result.computeIfPresent(data, (key, value) -> value + 1);
            result.computeIfAbsent(data, key -> 1);
        }
        return result;
    }

    private void validateBalls(Ball userBall, Ball computerBall) {
        List<Integer> userBallData = userBall.getBallData();
        List<Integer> computerBallData = computerBall.getBallData();
        if (userBallData.size() != computerBallData.size()) {
            throw new IllegalArgumentException("서로 호환 되지 않는 공입니다");
        }
    }
}
