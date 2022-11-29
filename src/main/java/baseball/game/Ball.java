package baseball.game;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Ball {
    private static final String BALL_SIZE_ERROR_MESSAGE = "[ERROR] 유효하지 않은 ball의 크기 입니다.";
    private static final String REDUPLICATION_ERROR_MESSAGE = "[ERROR] ball의 데이터는 중복을 허용하지 않습니다.";

    private List<Integer> ballData;
    private final int ballSize;

    public Ball(List<Integer> ball) {
        ballValidation(ball);
        this.ballSize = ball.size();
        this.ballData = new ArrayList<>(ball);
    }

    public EnumMap<ResultOfBall, Integer> getBallResult(Ball anotherBall) {
        EnumMap<ResultOfBall, Integer> result = new EnumMap<>(ResultOfBall.class);
        for (int i = 0; i < anotherBall.ballSize; i++) {
            ResultOfBall ballResult = judgeBall(i, anotherBall.ballData.get(i));
            result.computeIfPresent(ballResult, (key, value) -> value + 1);
            result.computeIfAbsent(ballResult, key -> 1);
        }
        return result;
    }

    public boolean isAllStrike(Ball anotherBall) {
        EnumMap<ResultOfBall, Integer> ballResult = getBallResult(anotherBall);
        if (!ballResult.containsKey(ResultOfBall.STRIKE)) {
            return false;
        }
        return ballResult.get(ResultOfBall.STRIKE) == ballSize;
    }

    private ResultOfBall judgeBall(int count, int ballNumber) {
        if (!ballData.contains(ballNumber)) {
            return ResultOfBall.MISS;
        }
        if (ballData.get(count) == ballNumber) {
            return ResultOfBall.STRIKE;
        }
        return ResultOfBall.BALL;
    }

    private void ballValidation(List<Integer> ball) {
        lengthValidation(ball);
        reduplicationValidation(ball);
    }

    private void lengthValidation(List<Integer> ball) {
        if (ball.size() > 9 || ball.size() < 1) {
            throw new IllegalArgumentException(BALL_SIZE_ERROR_MESSAGE);
        }
    }

    private void reduplicationValidation(List<Integer> ball) {
        long unReduplicationData = ball.stream().distinct().count();
        if (ball.size() != unReduplicationData) {
            throw new IllegalArgumentException(REDUPLICATION_ERROR_MESSAGE);
        }
    }
}
