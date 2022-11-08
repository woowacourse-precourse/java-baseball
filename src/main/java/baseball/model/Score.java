package baseball.model;

import java.util.Objects;

import static baseball.model.BaseBall.MAX_BASEBALL_SIZE;

public class Score {
    private static final String STRIKE_AND_BALL_CANNOT_BE_OVER_THREE = "스트라이크와 볼의 합이 3초과 일수는 없습니다.";
    public static final String SPACE = " ";

    private final int strike;
    private final int ball;

    public Score(int strike, int ball) {
        validateUnderThree(strike, ball);
        this.strike = strike;
        this.ball = ball;
    }

    private void validateUnderThree(int strike, int ball) {
        if (isOverThree(strike, ball)) {
            throw new RuntimeException(STRIKE_AND_BALL_CANNOT_BE_OVER_THREE);
        }
    }

    private static boolean isOverThree(int strike, int ball) {
        return strike + ball > MAX_BASEBALL_SIZE;
    }

    public String makeResultMessage(String ballMessage, String strikeMessage, String nothingMessage) {
        if (isZeroScore()) {
            return nothingMessage;
        }

        if (isZeroBall()) {
            return makeMessage(strike, strikeMessage);
        }

        if (isZeroStrike()) {
            return makeMessage(ball, ballMessage);
        }

        return makeMessage(ball, ballMessage) + SPACE + makeMessage(strike, strikeMessage);
    }

    private boolean isZeroScore() {
        return ball == 0 && strike == 0;
    }

    private boolean isZeroBall() {
        return ball == 0 && strike != 0;
    }

    private boolean isZeroStrike() {
        return strike == 0 && ball != 0;
    }

    private String makeMessage(int score, String message) {
        return score + message;
    }

    public boolean canContinue() {
        return strike != MAX_BASEBALL_SIZE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return strike == score.strike && ball == score.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strike, ball);
    }
}
