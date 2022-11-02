package baseball.domain.step;

import baseball.application.context.BaseBallGameContext;

public class ApplicationExitStep implements Step {

    @Override
    public void execute(BaseBallGameContext context) {
        throw new IllegalArgumentException("실행시킬 수 없습니다.");
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
