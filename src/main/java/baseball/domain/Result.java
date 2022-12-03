package baseball.domain;

public class Result {
    private int ballCount;
    private int strickCount;

    Result(int ballCount, int strickCount) {
        this.ballCount = ballCount;
        this.strickCount = strickCount;
    }

    public static Result of(int ballCount, int strickCount) {
        return new Result(ballCount, strickCount);
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrickCount() {
        return strickCount;
    }
}
