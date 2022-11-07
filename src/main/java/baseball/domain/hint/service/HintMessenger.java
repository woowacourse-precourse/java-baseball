package baseball.domain.hint.service;

import baseball.domain.hint.Hint;

public interface HintMessenger {

    boolean support(Hint hint);

    void printMessage(Hint hint);
}
