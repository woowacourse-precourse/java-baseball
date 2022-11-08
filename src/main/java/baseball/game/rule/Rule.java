package baseball.game.rule;

import baseball.enums.game.GuessTarget;

public interface Rule {

    GuessTarget getResult();

    Integer check(String answer, String guess);
}
