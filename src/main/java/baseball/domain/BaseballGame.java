package baseball.domain;

import baseball.utils.BaseballGameScoreCounter;
import baseball.utils.BaseballNumberGenerator;

public class BaseballGame {
    private String computerAnswer;

    public BaseballGame() {
        this.computerAnswer = BaseballNumberGenerator.generateNumber();
    }

    public Score compareNumber(String userAnswer) {
        return BaseballGameScoreCounter.checkScore(this.computerAnswer, userAnswer);
    }
}
