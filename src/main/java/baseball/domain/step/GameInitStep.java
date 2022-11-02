package baseball.domain.step;

import baseball.application.context.BaseBallGameContext;

public class GameInitStep implements Step{

    private static final Step NEXT = new InputNumberStep();

    @Override
    public void execute(BaseBallGameContext context) {
        context.init();
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
