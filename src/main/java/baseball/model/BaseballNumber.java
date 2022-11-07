package baseball.oop;

import baseball.model.Score;
import baseball.utils.BaseBallGameScoreCounter;
import baseball.utils.BaseballNumber;

public class BaseBallGameBoard {
    private String answer;

    public BaseBallGameBoard() {
        this.answer = BaseballNumber.generateNumber();
    }

    public Score compareNumber(String userAnswer) {
        return BaseBallGameScoreCounter.checkScore(this.answer, userAnswer);
    }
}
