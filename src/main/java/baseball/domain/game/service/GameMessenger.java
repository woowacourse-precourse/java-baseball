package baseball.domain.game.service;

import baseball.domain.hint.Hint;

public interface GameMessenger {

    String requestInputNumber();

    void sendHint(Hint hint);
}
