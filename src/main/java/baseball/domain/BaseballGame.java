package baseball.domain;

import baseball.domain.number.BaseballNumbers;
import baseball.domain.number.NumberGenerator;
import baseball.system.Constant;

public class BaseballGame {

    private final BaseballNumbers computerNumbers;
    private int strikeCount = 0;
    private int ballCount = 0;

    public BaseballGame(NumberGenerator numberGenerator) {
        this.computerNumbers = new BaseballNumbers(numberGenerator.generate());
    }

    public void playRound(BaseballNumbers userNumbers) {
        strikeCount = computerNumbers.countStrike(userNumbers);
        ballCount = computerNumbers.countBall(userNumbers);
    }

    public boolean isGameContinue() {
        return (strikeCount != Constant.NUMBERS_SIZE);
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
