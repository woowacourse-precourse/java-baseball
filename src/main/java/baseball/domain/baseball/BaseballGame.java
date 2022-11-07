package baseball.domain.baseball;

public class BaseballGame {
    private final BaseballContext baseballContext;

    public BaseballGame(BaseballContext baseballContext) {
        this.baseballContext = baseballContext;
    }

    public void run() {
        while (baseballContext.runAble()) {
            baseballContext.next();
        }
    }
}
