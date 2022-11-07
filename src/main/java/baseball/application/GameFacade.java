package baseball.application;

import baseball.domain.ball.Balls;
import baseball.domain.ball.service.BallService;
import baseball.domain.game.service.GameService;
import baseball.domain.hint.Hint;
import baseball.domain.hint.service.HintService;

public class GameFacade {

    private final BallService ballService;
    private final GameService gameService;
    private final HintService hintService;

    public GameFacade(BallService ballService, GameService gameService, HintService hintService) {
        this.ballService = ballService;
        this.gameService = gameService;
        this.hintService = hintService;
    }

    public Balls createAnswerBalls() {
        return ballService.createAnswerBalls();
    }

    public Balls createPlayerBalls() {
        final String number = gameService.requestInputNumber();
        gameService.validateNumber(number);
        return ballService.createPlayerBalls(number);
    }

    public boolean judgeIsAnswer(Hint hint) {
        return gameService.judgeIsAnswer(hint);
    }

    public boolean gameEndOrRestart() {
        return gameService.endOrRestart();
    }

    public Hint giveHint(Balls playerBall, Balls answerBall) {
        final Hint hint = hintService.createHint(playerBall, answerBall);
        hintService.sendHint(hint);
        return hint;
    }
}
