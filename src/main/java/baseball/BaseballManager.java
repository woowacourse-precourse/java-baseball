package baseball;

import java.util.List;

public class BaseballManager {
    BaseballNumber userNumber;
    BaseballNumber computerNumber;
    ScoreManager scoreManager;

    {
        computerNumber = new BaseballNumber(
                RandomNumGenerator.makeRandomNumWithNDigits(SystemConstant.GAME_DIGIT));
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
}
