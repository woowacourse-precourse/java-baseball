package baseball.dto;

import baseball.domain.Player;

public class GameResultResponseDto {

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
        return ball == CRITERION_ZERO;
    }

    public boolean isThreeStrike() {
        return strike == Player.GAME_ROUND;
    }
}
