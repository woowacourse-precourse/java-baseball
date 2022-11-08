package baseball.view;

import baseball.domain.BaseballGameResult;

public interface OutputView {
    void printGameStartMessage();

    void printInputMessage();

    void printRestartMessage();

    void print3StrikeMessage();

    void printBaseballGameResult(BaseballGameResult result);
}
