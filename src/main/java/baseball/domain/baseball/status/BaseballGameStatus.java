package baseball.domain.baseball.status;

import baseball.domain.baseball.BaseballGame;

public interface BaseballGameStatus {
    BaseballGameStatus next(BaseballGame baseballGame);

    boolean runAble();
}
