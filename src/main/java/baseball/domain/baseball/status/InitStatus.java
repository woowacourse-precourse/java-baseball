package baseball.domain.baseball.status;

import baseball.domain.baseball.BaseballGame;

public class InitStatus implements BaseballGameStatus {
    @Override
    public BaseballGameStatus next(BaseballGame baseballGame) {
        baseballGame.println("숫자 야구 게임을 시작합니다");
        return new GenerateAnswerStatus();
    }

    @Override
    public boolean runAble() {
        return true;
    }
}
