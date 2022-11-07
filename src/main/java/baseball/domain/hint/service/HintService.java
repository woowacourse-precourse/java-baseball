package baseball.domain.hint.service;

import baseball.domain.ball.Balls;
import baseball.domain.hint.Hint;

public interface HintService {

    Hint createHint(Balls playerBall, Balls answerBall);

    void sendHint(Hint hint);
}
