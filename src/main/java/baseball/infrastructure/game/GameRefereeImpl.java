package baseball.infrastructure.game;

import baseball.domain.ball.Balls;
import baseball.domain.hint.Hint;
import baseball.domain.game.service.GameReferee;
import baseball.global.utils.message.Number;

public class GameRefereeImpl implements GameReferee {

    @Override
    public Hint createHint(Balls playerBall, Balls answerBall) {
        final Integer strike = playerBall.getStrikeCount(answerBall);
        final Integer ball = playerBall.getBallCount(answerBall);
        return Hint.create(strike, ball);
    }

    @Override
    public boolean judgeIsAnswer(Hint hint) {
        return hint.getStrike() == Number.THREE;
    }

    @Override
    public boolean judgeContinueOrStop(String response) {
        return Number.CONTINUE.equals(response);
    }
}
