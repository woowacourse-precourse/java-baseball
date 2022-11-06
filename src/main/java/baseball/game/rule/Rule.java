package baseball.game.rule;

import baseball.game.enums.Result;

public interface Rule {

    Result getResult();

    Integer check(Integer answer, Integer guess);
}
