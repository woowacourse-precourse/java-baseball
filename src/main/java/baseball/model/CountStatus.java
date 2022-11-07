package baseball.view;

import baseball.model.Score;

import java.util.function.Predicate;

public enum CountStatus {
    NO_COUNT(score -> score.getBall() == 0 && score.getStrike() == 0),
    ONLY_BALL(score -> score.getBall() != 0 && score.getStrike() == 0),
    ONLY_STRIKE(score -> score.getBall() == 0 && score.getStrike() != 0),
    BALL_AND_STRIKE(score -> score.getBall() != 0 && score.getStrike() != 0);

    private Predicate<Score> expression;

    CountStatus(Predicate<Score> expression) {
        this.expression = expression;
    }

    public boolean check(Score score) {
        return expression.test(score);
    }

}
