package baseball.dto;

public class GameResultResponseDto {

    public static final int GAME_END_SCORE = 3;
    public static final int CRITERION_ZERO = 0;
    private final int strike;
    private final int ball;

    public GameResultResponseDto(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isStrikeZero() {
        return strike == CRITERION_ZERO;
    }

    public boolean isBallZero() {
        return ball == 0;
    }

    public boolean isThreeStrike() {
        return strike == GAME_END_SCORE;
    }
}
