package baseball.domain;

public enum GameState {
    NOTHING(0),
    GOOD(1),
    CORRECT(2);

    private int state;

    GameState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

}
