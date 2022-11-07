package baseball.Service;

public interface GameService {
    void generateNumber();
    int getUniqueNumber(String numStr);
    int [] getInputs();
    int calcStrike(int [] inputNumbers);
    int calcBallet(int [] inputNumbers);
    void calcResult(int [] inputNumbers);
    boolean isGameOver(int [] inputNumbers);
    boolean isContinueGame();
    boolean playGame();
}
