package baseball.domain;

import baseball.utils.BaseballNumbersGenerator;
import baseball.utils.Constants;

public class Baseball {

    private final Numbers computerNumbers;
    private boolean gameContinue = true;

    public Baseball(BaseballNumbersGenerator numbersGenerator) {
        this.computerNumbers = new Numbers(numbersGenerator.generate());
    }

    public boolean isGameContinue() {
        return gameContinue;
    }

    public int countStrike(Numbers userNumbers) {
        int strikeCount = computerNumbers.countCorrectNumber(userNumbers);
        if (strikeCount == Constants.NUMBERS_SIZE) {
            gameContinue = false;
        }
        return strikeCount;
    }

    public int countBall(Numbers userNumbers) {
        return computerNumbers.countSameNumber(userNumbers) - computerNumbers.countCorrectNumber(userNumbers);
    }
}
