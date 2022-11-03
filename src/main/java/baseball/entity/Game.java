package baseball.entity;

public interface Game {
    State state = State.START;
    void start();
    void end();
}
