package baseball.domain;

import baseball.dto.ScoreResult;
import java.util.List;
import java.util.stream.IntStream;

public class ScoreBoard {
    private List<NumberBall> systemNumberBalls;
    private boolean isPlaying;

    public ScoreBoard(List<NumberBall> systemNumberBalls) {
        if(systemNumberBalls == null) {
            initialize();
            return;
        }
        this.systemNumberBalls = systemNumberBalls;
        isPlaying = true;
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

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setIsPlaying() {
        isPlaying = false;
    }

    public void initialize() {
        systemNumberBalls = NumberBall.systemNumberBalls();
        isPlaying = true;
    }
}
