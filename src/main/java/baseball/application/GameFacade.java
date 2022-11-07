package baseball.application;

import baseball.domain.ball.Balls;
import baseball.domain.ball.service.BallService;
import baseball.domain.game.service.GameService;

public class GameFacade {

    private final BallService ballService;
    private final GameService gameService;

    public GameFacade(BallService ballService, GameService gameService) {
        this.ballService = ballService;
        this.gameService = gameService;
    }

    public Balls createAnswerBalls() {
        return ballService.createAnswerBalls();
    }

    public Balls createPlayerBalls() {
        final String number = gameService.requestInputNumber();
        gameService.validateNumber(number);
        return ballService.createPlayerBalls(number);
    }
}
