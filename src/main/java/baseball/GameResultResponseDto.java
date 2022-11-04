package baseball;

public class GameResultResponseDto {

    public static final int GAME_END_SCORE = 3;
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

    public boolean isThreeStrike() {
        return strike == GAME_END_SCORE;
    }
}
