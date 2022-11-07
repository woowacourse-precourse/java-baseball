package baseball.application;

import baseball.domain.ball.Balls;
import baseball.domain.ball.service.BallService;

public class GameFacade {

    private final BallService ballService;

    public GameFacade(BallService ballService) {
        this.ballService = ballService;
    }

    public Balls createAnswerBalls() {
        return ballService.createAnswerBalls();
    }
}
