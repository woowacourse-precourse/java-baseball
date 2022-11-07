package baseball.domain.baseball.status;

import baseball.domain.baseball.BaseballContext;

public class GameEndStatus implements BaseballGameStatus {
    @Override
    public BaseballGameStatus next(BaseballContext baseballContext) {
        return null;
    }

    @Override
    public boolean runAble() {
        return false;
    }
}
