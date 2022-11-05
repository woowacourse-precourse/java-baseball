package baseball.domain.baseball.status;

import baseball.domain.baseball.BaseballContext;

public class GenerateAnswerStatus implements BaseballGameStatus {
    @Override
    public BaseballGameStatus next(BaseballContext baseballContext) {
        baseballContext.initializeComputerNumber();
        return new UserInputStatus();
    }

    @Override
    public boolean runAble() {
        return true;
    }
}
