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
            if (systemNumberBalls.get(i).equals(userNumberBalls.get(i))) {
                strike++;
                continue;
            }
            int finalI = i;
            boolean aa = systemNumberBalls.stream()
                    .anyMatch(systemNumberBall -> systemNumberBall.equals(userNumberBalls.get(finalI)));
            if(aa) {
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

    public void setIsPlaying() {
        isPlaying = false;
    }
}
