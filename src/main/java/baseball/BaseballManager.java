package baseball;

import java.util.List;

public class BaseballManager {
    private BaseballNumber userNumber;
    private BaseballNumber computerNumber;
    private ScoreManager scoreManager = new ScoreManager();

    {
        initComputerNumber();
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

    public void initComputerNumber() {
        computerNumber = new BaseballNumber(
                RandomNumGenerator.makeDistinctRandomNumWithSize(SystemConstant.GAME_DIGIT));
    }
}
