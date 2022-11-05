package baseball.Service;

public interface GameService {
    void generateNumber();
    int getUniqueNumber(String numStr);
    int [] getInputs();
    int calcStrike(int [] inputNumbers);
}
