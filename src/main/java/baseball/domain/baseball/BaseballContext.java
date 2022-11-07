package baseball.domain.baseball;

import baseball.domain.score.Score;

public interface BaseballContext {
    boolean runAble();

    Score ruled();

    void next();

    void println(final String message);

    void print(final String message);

    void initializeComputerNumber();

    String input();

    void initializeParticipantNumber(String input);
}
