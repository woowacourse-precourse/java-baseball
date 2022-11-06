package baseball.model.hint;

import baseball.model.number.BaseballNumbers;

public class Hint {
    private static final String BALL_STRING = "볼";
    private static final String STRIKE_STRING = "스트라이크";
    private static final String NOTHING_STRING = "낫싱";
    private static final String SPACE_STRING = " ";

    private final BaseballNumbers answerBaseballNumbers;
    private final BaseballNumbers inputBaseballNumbers;

    public Hint(BaseballNumbers answerBaseballNumbers, BaseballNumbers inputBaseballNumbers) {
        this.answerBaseballNumbers = answerBaseballNumbers;
        this.inputBaseballNumbers = inputBaseballNumbers;
    }

    public String getResult() {
        if(answerBaseballNumbers.isNothing(inputBaseballNumbers)) {
            return NOTHING_STRING;
        }
        int strikeCount = answerBaseballNumbers.getStrike(inputBaseballNumbers);
        int ballCount = answerBaseballNumbers.getBall(inputBaseballNumbers);
        String result = ballCount + BALL_STRING + SPACE_STRING + strikeCount + STRIKE_STRING;
        return result;
    }

}
