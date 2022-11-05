package baseball;

import java.util.List;
import java.util.stream.IntStream;

public class Referee {
    private int strikeCount;
    private int ballCount;

    public Referee() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public void judgeGameResult(List<Ball> hitterBalls, List<Ball> pitcherBalls) {
        hitterBalls.stream()
                .forEach(hitterBall -> count(hitterBall.getResult(pitcherBalls)));
    }

    private void count(BaseballJudge baseballJudge) {
        if (baseballJudge.equals(BaseballJudge.STRIKE)) {
            strikeCount += 1;
        }

        if (baseballJudge.equals(BaseballJudge.BALL)) {
            ballCount += 1;
        }
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
