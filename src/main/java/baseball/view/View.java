package baseball.view;

import java.util.List;

public interface View {
    void initialStart();
    void requestGuess();
    void result(int ball, int strike);
    void end();
    void askRetry();
}
