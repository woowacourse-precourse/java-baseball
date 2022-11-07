package baseball.domain.baseball.status;

import baseball.domain.baseball.BaseballContext;

public class InitStatus implements BaseballGameStatus {
    public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    @Override
    public BaseballGameStatus next(BaseballContext baseballContext) {
        baseballContext.println(GAME_START_MESSAGE);
        return new GenerateAnswerStatus();
    }

    @Override
    public boolean runAble() {
        return true;
    }
}
