package baseball.view;

public interface View {
    void initialStart();
    String requestGuess();
    void result(int ball, int strike);
    void end();
    boolean askRetry();
}
