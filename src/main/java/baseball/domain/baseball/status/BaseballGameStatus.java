package baseball.domain.baseball.status;

import baseball.domain.baseball.BaseballContext;

public interface BaseballGameStatus {
    BaseballGameStatus next(BaseballContext baseballContext);

    boolean runAble();
}
