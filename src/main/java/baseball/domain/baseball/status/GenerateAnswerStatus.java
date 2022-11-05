package baseball.domain.baseball.status;

import baseball.domain.baseball.BaseballGame;

public class GenerateAnswerStatus implements BaseballGameStatus {
    @Override
    public BaseballGameStatus next(BaseballGame baseballGame) {
        baseballGame.initializeComputerNumber();
        return new UserInputStatus();
    }

    @Override
    public boolean runAble() {
        return true;
    }
}
