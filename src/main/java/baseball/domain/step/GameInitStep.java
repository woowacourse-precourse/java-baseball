package baseball.domain.step;

import baseball.application.context.BaseBallGameContext;

public class GameInitStep implements Step{

    @Override
    public void execute(BaseBallGameContext context) {

    }

    @Override
    public Step next() {
        return null;
    }

    @Override
    public boolean executable() {
        return false;
    }
}
