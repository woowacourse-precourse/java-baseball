package baseball.rule;

import baseball.domain.BallCount;

public class EndRule {

    public static boolean isGameEnd(BallCount ballCount) {
        return ballCount.ballCountResult().equals("3스트라이크");
    }

}
