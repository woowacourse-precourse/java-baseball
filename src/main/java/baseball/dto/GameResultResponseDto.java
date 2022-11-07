package baseball.dto;

public class GameResultResponseDto {

    public static final int CRITERION_ZERO = 0;

    private final boolean isGameEnd;
    private final int strike;
    private final int ball;

    public GameResultResponseDto(boolean isGameEnd, int strike, int ball) {
        this.isGameEnd = isGameEnd;
        this.strike = strike;
        this.ball = ball;
    }

    public boolean isStrikeZero() {
        return strike == CRITERION_ZERO;
    }

    public boolean isBallZero() {
        return ball == CRITERION_ZERO;
    }

    public boolean isGameEnd() {
        return isGameEnd;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

}
