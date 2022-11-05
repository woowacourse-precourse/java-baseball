package baseball.domain.step;

import baseball.application.context.BaseBallGameContext;

public class GameStartStep implements Step {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    private static final Step NEXT = new GameInitStep();

    @Override
    public void execute(BaseBallGameContext context) {
        context.println(START_MESSAGE);
    }

    @Override
    public Step next() {
        return NEXT;
    }

    @Override
    public boolean executable() {
        return true;
    }
}
