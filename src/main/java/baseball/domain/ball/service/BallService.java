package baseball.domain.ball.service;

import baseball.domain.ball.Balls;

public interface BallService {

    Balls createAnswerBalls();

    Balls createPlayerBalls(String number);
}
