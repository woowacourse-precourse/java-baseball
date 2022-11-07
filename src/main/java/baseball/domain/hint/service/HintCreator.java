package baseball.domain.hint.service;

import baseball.domain.ball.Balls;
import baseball.domain.hint.Hint;

public interface HintCreator {

    Hint createHint(Balls playerBall, Balls answerBall);

}
