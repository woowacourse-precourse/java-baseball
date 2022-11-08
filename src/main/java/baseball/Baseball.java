package baseball;

import java.util.List;

public class Baseball {
    private int ballCount;
    private int strikeCount;
    private static final int MAX_STRIKE_COUNT = 3;

    public void countStrikeAndBall(List<Integer> computer, List<Integer> player) {
        Ball ball = new Ball(player, computer);
        Strike strike = new Strike(player, computer);
        this.ballCount = ball.getCount();
        this.strikeCount = strike.getCount();
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public boolean isMaxStrike() {
        return getStrikeCount() == MAX_STRIKE_COUNT;
    }
}
