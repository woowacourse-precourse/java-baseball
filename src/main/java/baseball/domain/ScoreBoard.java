package baseball.domain;

import baseball.dto.ScoreResult;
import java.util.List;
import java.util.stream.IntStream;

public class ScoreBoard {
    private List<NumberBall> systemNumberBalls;

    public ScoreBoard(List<NumberBall> systemNumberBalls) {
        this.systemNumberBalls = systemNumberBalls;
    }

    public ScoreResult getScoreResult(List<NumberBall> userNumberBalls) {
        return new ScoreResult.Builder()
                .setStrike(countStrike(userNumberBalls))
                .setBall(countBall(userNumberBalls))
                .build();
    }

    private int countStrike(List<NumberBall> userNumberBalls) {
        return (int) IntStream.range(0, 3)
                .filter(idx -> systemNumberBalls.get(idx).equals(userNumberBalls.get(idx)))
                .count();
    }

    private int countBall(List<NumberBall> userNumberBalls) {
        return (int) IntStream.range(0, 3)
                .filter(idx -> !systemNumberBalls.get(idx).equals(userNumberBalls.get(idx)))
                .filter(idx -> systemNumberBalls.contains(userNumberBalls.get(idx)))
                .count();
    }
}
