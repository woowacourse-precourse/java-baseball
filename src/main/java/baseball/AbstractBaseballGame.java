package baseball;

public abstract class AbstractBaseballGame {
    public final void run() {
        startEventBeforePlay();
        do {
            play();
        } while (startEventAfterPlay());
    }

    protected abstract void startEventBeforePlay();

    protected abstract void play();

    protected abstract boolean startEventAfterPlay();
}
