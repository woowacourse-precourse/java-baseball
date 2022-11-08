package baseball.view;

public interface View {
    void initialStart();
    void requestGuess();
    void result();
    void end();
    void askRetry();
}
