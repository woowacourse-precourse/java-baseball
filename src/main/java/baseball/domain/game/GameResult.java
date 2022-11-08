package baseball.domain.game;

import baseball.util.GameNumberConst;

public class GameResult {

    private static final String TOO_MANY_ANSWER = "잘못된 정답 개수입니다.";

    private final long strike;
    private final long ball;

    public GameResult(long strike, long ball) {
        validateAnswer(strike, ball);

        this.strike = strike;
        this.ball = ball;
    }

    private void validateAnswer(long strike, long ball) {
        validateAnswerCount(strike);
        validateAnswerCount(ball);
        validateAnswerCount(strike + ball);
    }

    private void validateAnswerCount(long target) {
        if (target > GameNumberConst.MAX_GAME_NUMBER_SIZE) {
            throw new IllegalArgumentException(TOO_MANY_ANSWER);
        }
    }

    public boolean isOnlyStrike() {
        return this.strike > 0 && this.ball == 0;
    }

    public boolean isOnlyBall() {
        return this.strike == 0 && this.ball > 0;
    }

    public boolean isStrikeAndBall() {
        return this.strike > 0 && this.ball > 0;
    }

    public boolean isCorrect() {
        return this.strike == GameNumberConst.MAX_GAME_NUMBER_SIZE;
    }

    public long getStrike() {
        return this.strike;
    }

    public long getBall() {
        return this.ball;
    }
}
