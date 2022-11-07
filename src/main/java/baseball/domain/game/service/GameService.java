package baseball.domain.game.service;

import baseball.domain.hint.Hint;

public interface GameService {

    String requestInputNumber();

    void validateNumber(String number);

    boolean judgeIsAnswer(Hint hint);

    boolean endOrRestart();
}
