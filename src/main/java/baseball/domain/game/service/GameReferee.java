package baseball.domain.game.service;

import baseball.domain.hint.Hint;

public interface GameReferee {

    boolean judgeIsAnswer(Hint hint);

    boolean judgeContinueOrStop(String response);
}
