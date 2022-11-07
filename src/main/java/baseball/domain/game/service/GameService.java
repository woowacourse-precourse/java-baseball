package baseball.domain.game.service;

import baseball.domain.ball.Balls;

public interface GameService {

    String requestInputNumber();

    void validateNumber(String number);

    boolean judge(Balls playerBall, Balls answerBall);
}
