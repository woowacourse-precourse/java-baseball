package baseball.domain.baseball.status;

import baseball.domain.baseball.BaseballContext;

public class UserInputStatus implements BaseballGameStatus {
    @Override
    public BaseballGameStatus next(BaseballContext baseballContext) {
        baseballContext.print("숫자를 입력해주세요 : ");

        String input = baseballContext.input();
        baseballContext.initializeParticipantNumber(input);

        return new CompareAnswerStatus();
    }

    @Override
    public boolean runAble() {
        return true;
    }
}
