package baseball.domain.hint;

public interface HintMessenger {

    boolean support(Hint hint);

    void printMessage(Hint hint);
}
