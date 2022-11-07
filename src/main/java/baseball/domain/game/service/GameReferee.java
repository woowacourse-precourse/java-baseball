package baseball.domain.game.service;

import baseball.domain.ball.Balls;
import baseball.domain.hint.Hint;

public interface GameReferee {

    Hint createHint(Balls playerBall, Balls answerBall);

    boolean judgeIsAnswer(Hint hint);

    boolean judgeContinueOrStop(String response);
}
