package baseball.model;

import baseball.utils.BaseBallGameScoreCounter;
import baseball.utils.BaseballNumberGenerator;

public class BaseballNumber {
    private String answer;

    public BaseballNumber() {
        this.answer = BaseballNumberGenerator.generateNumber();
    }

    public Score compareNumber(String userAnswer) {
        return BaseBallGameScoreCounter.checkScore(this.answer, userAnswer);
    }
}
