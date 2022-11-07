package baseball.presentation;

import baseball.application.GameFacade;
import baseball.domain.ball.Balls;
import baseball.domain.hint.Hint;

public class BaseBallGameController {

    private final GameFacade gameFacade;

    public BaseBallGameController(GameFacade gameFacade) {
        this.gameFacade = gameFacade;
    }

    public boolean baseballGame() {
        boolean isAnswer;

        final Balls answerBall = gameFacade.createAnswerBalls();

        do {
            final Balls playerBall = gameFacade.createPlayerBalls();
            final Hint hint = gameFacade.giveHint(answerBall, playerBall);
            isAnswer = gameFacade.judgeIsAnswer(hint);
        } while (!isAnswer);

        return gameFacade.gameEndOrRestart();
    }
}
