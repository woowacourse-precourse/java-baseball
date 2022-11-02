package baseball.application;

import baseball.application.config.BaseBallGameConfig;
import baseball.application.context.BaseBallGameContext;
import baseball.domain.step.GameStartStep;
import baseball.domain.step.Step;

public class BaseBallApplication {

    private final BaseBallGameContext context;

    private Step step = new GameStartStep();

    public BaseBallApplication(BaseBallGameConfig config) {
        this.context = new BaseBallGameContext(config);
    }

    public void play() {
       while (step.executable()) {
           step.execute(context);
           step = step.next();
       }
    }
}
