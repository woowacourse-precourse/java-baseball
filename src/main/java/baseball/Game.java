package baseball;

public abstract class Game {
    protected abstract void greet();

    protected abstract void play();

    protected abstract void close();

    protected abstract boolean restart();

    final public void run() {
        greet();
        while (restart()) {
            play();
            close();
        }
    }
}
