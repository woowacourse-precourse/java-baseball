package baseball.infrastructure.hint;

import baseball.domain.ball.Balls;
import baseball.domain.hint.Hint;
import baseball.domain.hint.service.HintCreator;

public class HintCreatorImpl implements HintCreator {

    @Override
    public Hint createHint(Balls playerBall, Balls answerBall) {
        final Integer strike = playerBall.getStrikeCount(answerBall);
        final Integer ball = playerBall.getBallCount(answerBall);
        return Hint.create(strike, ball);
    }
}
