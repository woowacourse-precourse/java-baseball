package baseball.domain;

import baseball.dto.ScoreResult;
import java.util.List;

public class ScoreBoard {
    private List<NumberBall> systemNumberBalls;
    private boolean isPlaying = true;

    public ScoreBoard(List<NumberBall> systemNumberBalls) {
        this.systemNumberBalls = systemNumberBalls;
    }

    public ScoreResult getScore(List<NumberBall> userNumberBalls) {
        int strike = 0, ball = 0;
        for (int i = 0; i < 3; i++) {
            if (systemNumberBalls.get(i) == userNumberBalls.get(i)) {
                strike++;
            } else if (systemNumberBalls.contains(userNumberBalls.get(i))) {
                ball++;
            }
        }
        return new ScoreResult.Builder()
                .setStrike(strike)
                .setBall(ball)
                .build();
    }


    public boolean isPlaying() {
        return isPlaying;
    }
}
