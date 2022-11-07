package baseball.model.hint;

import static baseball.model.Constant.BALL_STRING;
import static baseball.model.Constant.NOTHING_STRING;
import static baseball.model.Constant.NULL_STRING;
import static baseball.model.Constant.SPACE_STRING;
import static baseball.model.Constant.STRIKE_STRING;

import baseball.model.number.BaseballNumbers;

public class Hint {
    private final BaseballNumbers answerBaseballNumbers;
    private final BaseballNumbers inputBaseballNumbers;

    public Hint(BaseballNumbers answerBaseballNumbers, BaseballNumbers inputBaseballNumbers) {
        this.answerBaseballNumbers = answerBaseballNumbers;
        this.inputBaseballNumbers = inputBaseballNumbers;
    }

    public boolean isCorrectNumber() {
        int strikeCount = answerBaseballNumbers.getStrike(inputBaseballNumbers);
        if(strikeCount == 3) {
            return true;
        }
        return false;
    }

    public String getBaseballNumberCount() {
        if(answerBaseballNumbers.isNothing(inputBaseballNumbers)) {
            return NOTHING_STRING;
        }
        int strikeCount = answerBaseballNumbers.getStrike(inputBaseballNumbers);
        int ballCount = answerBaseballNumbers.getBall(inputBaseballNumbers);
        String result = makeCountString(ballCount, strikeCount);
        return result;
    }

    private String makeCountString(int ballCount, int strikeCount) {
        String result = getBallResult(ballCount);
        if(ballCount > 0) {
            result += SPACE_STRING;
        }
        result += getStrikeResult(strikeCount);
        return result;
    }

    private String getBallResult(int ballCount) {
        if(ballCount == 0) {
            return NULL_STRING;
        }
        return ballCount + BALL_STRING;
    }

    private String getStrikeResult(int strikeCount) {
        if(strikeCount == 0) {
            return NULL_STRING;
        }
        return strikeCount + STRIKE_STRING;
    }

}
