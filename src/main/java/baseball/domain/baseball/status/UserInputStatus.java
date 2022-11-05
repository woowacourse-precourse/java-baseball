package baseball.domain.baseball.status;

import baseball.domain.baseball.BaseballGame;

public class UserInputStatus implements BaseballGameStatus {
    @Override
    public BaseballGameStatus next(BaseballGame baseballGame) {
        baseballGame.print("숫자를 입력해주세요 : ");
        String input = baseballGame.input();
        baseballGame.initializeParticipantNumber(input);

        return new CompareAnswerStatus();
    }

    @Override
    public boolean runAble() {
        return true;
    }
}
