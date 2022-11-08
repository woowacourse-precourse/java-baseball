package baseball.game.rule;

import baseball.game.enums.GuessTarget;

public interface Rule {

    GuessTarget getResult();

    Integer check(String answer, String guess);
}
