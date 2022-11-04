package baseball.domain.count.ball;

public class BallResult {

    private final int ballCount;

    BallResult(int ballCount) {
        this.ballCount = ballCount;
    }

    public int ballCount() {
        return ballCount;
    }
}
