package baseball.engine;

public enum PlayState {
    RUN(1),
    QUIT(2);

    private final int state;

    PlayState(int state) {
        this.state = state;
    }

    public int getState() {
        return this.state;
    }
}
