package baseball.domain.step;

import baseball.application.context.BaseBallGameContext;

public interface Step {

    void execute(BaseBallGameContext context);

    Step next();

    boolean executable();
}
