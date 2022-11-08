package baseball.domain.game;

import static baseball.utils.Constants.*;

public class Result {
    private final GameHint gameHint;

    private Result(GameHint gameHint) {
        this.gameHint = gameHint;
    }

    public static Result of(GameHint gameHint) {
        return new Result(gameHint);
    }

    public boolean isThreeStrike() {
        return gameHint.getStrikeScore() == BASEBALL_DIGIT_LENGTH;
    }

    public String getResult() {
        if (isNothing()) {
            return NOTHING;
        }

        StringBuilder result = new StringBuilder();

        if (gameHint.getBallScore() > 0) {
            result.append(gameHint.getBallScore());
            result.append(BALL);
        }

        if (gameHint.getStrikeScore() > 0) {
            result.append(gameHint.getStrikeScore());
            result.append(STRIKE);
        }

        return result.toString().trim();
    }

    private boolean isNothing() {
        return (gameHint.getBallScore() == 0) && (gameHint.getStrikeScore() == 0);
    }
}
