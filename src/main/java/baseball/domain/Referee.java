package baseball.domain;

import baseball.dto.GameResultResponseDto;

import java.util.Objects;

public class Referee {

    public static final int INIT_SCORE = 0;
    private int strike;
    private int ball;

    public Referee() {
        this(INIT_SCORE, INIT_SCORE);
    }

    public Referee(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public void addScore(BallMatchResult status) {
        if (status.isStrike()) {
            strike++;
        }
        if (status.isBall()) {
            ball++;
        }
    }

    public boolean isGameEnd() {
        return strike == Player.GAME_ROUND;
    }

    public GameResultResponseDto toResponseDto() {
        return new GameResultResponseDto(isGameEnd(), strike, ball);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Referee that = (Referee) o;
        return strike == that.strike && ball == that.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strike, ball);
    }

}
