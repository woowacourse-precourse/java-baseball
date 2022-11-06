package baseball;

public abstract class AbstractBaseballGame {
    public void run() {
        startEventBeforePlay();
        do {
            play();
        } while (startEventAfterPlay().startsGame());
    }

    protected abstract void startEventBeforePlay();
    protected abstract void play();
    protected abstract ControlNumber startEventAfterPlay();
}
