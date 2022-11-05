package baseball.domain.baseball.status;

import baseball.domain.baseball.BaseballGame;

public class GameEndStatus implements BaseballGameStatus {
    @Override
    public BaseballGameStatus next(BaseballGame baseballGame) {
        return null;
    }

    @Override
    public boolean runAble() {
        return false;
    }
}
