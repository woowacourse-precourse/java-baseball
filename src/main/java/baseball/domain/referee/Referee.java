package baseball.domain.referee;

public interface Referee {

    boolean isEachSetContext();

    void updateEachSetContext(String resultMessage);

    void clearEachSetContext();
}
