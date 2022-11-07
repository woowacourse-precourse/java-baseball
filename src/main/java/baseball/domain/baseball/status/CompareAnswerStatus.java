package baseball.domain.baseball.status;

import baseball.domain.baseball.BaseballContext;

public class CompareAnswerStatus implements BaseballGameStatus {

    @Override
    public BaseballGameStatus next(BaseballContext baseballContext) {
        var score = baseballContext.ruled();
        var result = score.result();

        baseballContext.println(result);

        if (score.strikeAll()) {
            return new RequestContinueStatus();
        }
        return new UserInputStatus();
    }

    @Override
    public boolean runAble() {
        return true;
    }
}
