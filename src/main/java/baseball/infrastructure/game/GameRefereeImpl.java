package baseball.infrastructure.game;

import baseball.domain.game.service.GameReferee;
import baseball.domain.hint.Hint;
import baseball.global.utils.message.Number;

public class GameRefereeImpl implements GameReferee {

    @Override
    public boolean judgeIsAnswer(Hint hint) {
        return hint.getStrike() == Number.THREE;
    }

    @Override
    public boolean judgeContinueOrStop(String response) {
        return Number.CONTINUE.equals(response);
    }
}
