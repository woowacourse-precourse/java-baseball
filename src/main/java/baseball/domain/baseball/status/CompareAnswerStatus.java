package baseball.domain.baseball.status;

import baseball.domain.baseball.BaseballGame;

public class CompareAnswerStatus implements BaseballGameStatus {
    @Override
    public BaseballGameStatus next(BaseballGame baseballGame) {
        var score = baseballGame.ruled();
        var result = score.result();
        baseballGame.println(result);
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
