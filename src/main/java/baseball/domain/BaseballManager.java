package baseball.domain;

import baseball.domain.dto.Score;
import baseball.system.SystemConstant;

public class BaseballManager {
    private BaseballNumber userNumber;
    private BaseballNumber computerNumber;

    {
        initComputerNumber();
    }

    public void addUserBaseballNumInfo(BaseballNumber baseballNum1) {
        userNumber = baseballNum1;
    }

    public Score computeUserScore() {
        return ScoreCalculator.calculateUserFinalScore(userNumber, computerNumber);
    }

    public void initComputerNumber() {
        computerNumber = new BaseballNumber(
                RandomNumGenerator.makeDistinctRandomNumWithSize(SystemConstant.GAME_DIGIT));
    }
}
