package baseball.domain;

import java.util.List;

public class Player {

    private final Referee referee;

    private BallCount ballCount;

    public Player(Referee referee) {
        this.referee = referee;
    }

    public String checkCounts(List<Integer> inputs) {
        this.ballCount = referee.checkCounts(inputs);
        return ballCount.toString();
    }

    public boolean isAllStrike() {
        return ballCount.isAllStrike();
    }
}
