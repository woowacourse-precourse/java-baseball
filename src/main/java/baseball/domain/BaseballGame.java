package baseball.domain;

import baseball.domain.dto.Score;
import baseball.system.SystemConstant;

public class BaseballGame {
    private BaseballNumber computerNumber;

    public Score computeUserScore(int number) {
        BaseballNumber userNumber = new BaseballNumber(number);
        return ScoreCalculator.calculateUserFinalScore(userNumber, computerNumber);
    }

    public void initComputerNumber() {
        computerNumber = new BaseballNumber(
                RandomNumGenerator.makeDistinctRandomNumWithSize(SystemConstant.GAME_DIGIT));
    }
}
