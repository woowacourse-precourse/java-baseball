package baseball.model;

import java.util.Objects;

import static baseball.model.BaseBall.MAX_BASEBALL_SIZE;

public class Score {
    private static final String STRIKE_AND_BALL_CANNOT_BE_OVER_THREE = "스트라이크와 볼의 합이 3초과 일수는 없습니다.";
    public static final String SPACE = " ";
    public static final int INITIAL_BALL = 0;
    public static final int INITIAL_STRIKE = 0;

    private final int strike;
    private final int ball;

    public Score() {
        this.strike = INITIAL_STRIKE;
        this.ball = INITIAL_BALL;
    }

    public Score(int strike, int ball) {
        validateUnderMaxBaseballSize(strike, ball);
        this.strike = strike;
        this.ball = ball;
    }

    private void validateUnderMaxBaseballSize(int strike, int ball) {
        if (isOverMaxBaseballSize(strike, ball)) {
            throw new IllegalStateException(STRIKE_AND_BALL_CANNOT_BE_OVER_THREE);
        }
    }

    private static boolean isOverMaxBaseballSize(int strike, int ball) {
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

        return makeBallAndStrikeMessage(ballMessage, strikeMessage);
    }

    private boolean isZeroScore() {
        return ball == INITIAL_BALL && strike == INITIAL_STRIKE;
    }

    private boolean isZeroBall() {
        return ball == INITIAL_BALL && strike != INITIAL_STRIKE;
    }

    private boolean isZeroStrike() {
        return strike == INITIAL_STRIKE && ball != INITIAL_BALL;
    }

    private String makeMessage(int score, String message) {
        return score + message;
    }

    private String makeBallAndStrikeMessage(String ballMessage, String strikeMessage) {
        return makeMessage(ball, ballMessage) + SPACE + makeMessage(strike, strikeMessage);
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
