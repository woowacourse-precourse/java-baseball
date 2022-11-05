package baseball.application;

import baseball.application.config.BaseBallGameConfig;
import baseball.application.context.BaseBallGameContext;

public class BaseBallApplication {

    private final BaseBallGameContext context;

    public BaseBallApplication(BaseBallGameConfig config) {
        this.context = new BaseBallGameContext(config);
    }

    public void play() {
       while (context.executable()) {
           context.execute();
       }
    }
}
