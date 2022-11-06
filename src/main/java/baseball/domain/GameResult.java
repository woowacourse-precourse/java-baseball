package baseball.domain;

import baseball.dto.GameResultResponseDto;

import java.util.Objects;

public class GameResult {

    public static final int DEFAULT_SCORE = 0;
    private int strike;
    private int ball;

    public GameResult() {
        this(DEFAULT_SCORE, DEFAULT_SCORE);
    }

    public GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public void addResult(BallStatus status) {
        if (status.isStrike()) {
            strike++;
        }
        if (status.isBall()) {
            ball++;
        }
    }

    public GameResultResponseDto toResponseDto() {
        return new GameResultResponseDto(strike, ball);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult that = (GameResult) o;
        return strike == that.strike && ball == that.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strike, ball);
    }

}
