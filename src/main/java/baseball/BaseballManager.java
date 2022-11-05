package baseball;

import java.util.List;

public class BaseballManager {
    private BaseballNumber userNumber;
    private BaseballNumber computerNumber;
    private ScoreManager scoreManager = new ScoreManager();

    {
        computerNumber = new BaseballNumber(
                RandomNumGenerator.makeRandomNumWithGameDigits());
    }

    public void addUserBaseballNumInfo(BaseballNumber baseballNum1) {
        userNumber = baseballNum1;
    }

    public void computeUserScore() {
        scoreManager.makeUserScore(userNumber, computerNumber);
    }

    public List<Integer> getUserScore() {
        return scoreManager.getUserScore();
    }

    public void resetComputerNumber() {
        computerNumber = new BaseballNumber(
                RandomNumGenerator.makeRandomNumWithGameDigits());
    }
}
