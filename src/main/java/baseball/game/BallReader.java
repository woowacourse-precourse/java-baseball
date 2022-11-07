package baseball.game;

import java.util.*;

public class BallReader {
    private static ResultOfBall BALL = ResultOfBall.BALL;
    private static ResultOfBall STRIKE = ResultOfBall.STRIKE;
    private static ResultOfBall MISS = ResultOfBall.MISS;
    private int requiredStrikes;

    public BallReader() {
        this.requiredStrikes = 3;
    }

    public BallReader(int countOfStrike) {
        this.requiredStrikes = countOfStrike;
    }

    public boolean isGameOver(Ball userBall, Ball computerBall) {
        Map<ResultOfBall, Integer> result = getStrikeAndBall(userBall, computerBall);
        if (result.get(STRIKE) == null) {
            return false;
        }
        return result.get(STRIKE) == requiredStrikes;
    }

    public EnumMap<ResultOfBall, Integer> getStrikeAndBall(Ball userBall, Ball computerBall) {
        validateBalls(userBall, computerBall);
        return makeMapByStrikeAndBall(makeStrikeAndBall(userBall, computerBall));
    }

    private void validateBalls(Ball userBall, Ball computerBall) {
        List<Integer> userBallData = userBall.getBallData();
        List<Integer> computerBallData = computerBall.getBallData();
        if (userBallData.size() != computerBallData.size()) {
            throw new IllegalArgumentException("서로 호환 되지 않는 공입니다");
        }
    }

    private List<ResultOfBall> makeStrikeAndBall(Ball userBall, Ball computerBall) {
        List<ResultOfBall> strikeAndBallResult = new ArrayList<>();

        List<Integer> userBallData = userBall.getBallData();
        List<Integer> computerBallData = computerBall.getBallData();
        for (int number : userBallData) {
            int userIndex = userBallData.indexOf(number);
            int computerIndex = computerBallData.indexOf(number);
            ResultOfBall result = judgeStrikeOrBall(userIndex, computerIndex);
            strikeAndBallResult.add(result);
        }
        return strikeAndBallResult;
    }

    private EnumMap<ResultOfBall, Integer> makeMapByStrikeAndBall(List<ResultOfBall> ballData) {
        EnumMap<ResultOfBall, Integer> result = new EnumMap<ResultOfBall, Integer>(ResultOfBall.class);
        List<ResultOfBall> onlyStrikeAndBall = removeMissBall(ballData);
        for (ResultOfBall data : onlyStrikeAndBall) {
            result.computeIfPresent(data, (key, value) -> value + 1);
            result.computeIfAbsent(data, key -> 1);
        }
        return result;
    }

    private List<ResultOfBall> removeMissBall(List<ResultOfBall> ballData) {
        List<ResultOfBall> result = new ArrayList<>(ballData);
        while (result.remove(ResultOfBall.MISS)) {
        }
        return result;
    }

    private ResultOfBall judgeStrikeOrBall(int userIndex, int computerIndex) {
        final int noNumberInComputer = -1;
        if (userIndex == computerIndex) {
            return STRIKE;
        }
        if (userIndex != computerIndex && computerIndex != noNumberInComputer) {
            return BALL;
        }
        return MISS;
    }

}
