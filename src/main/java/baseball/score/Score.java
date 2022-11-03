package baseball.score;

public interface Score {
    public int getStrike();

    public int getBall();

    default boolean isSame(int strike, int ball) {
        return strike == getStrike() && ball == getBall();
    }
}
