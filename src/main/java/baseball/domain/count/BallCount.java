package baseball.domain.count;

import baseball.domain.ThreeDigitNum;

public class BallCount extends Count {
    public static final String BALL_MESSAGE = "볼";

    public BallCount(ThreeDigitNum answer, ThreeDigitNum input) {
        super(answer, input);
    }

    public static BallCount makeBallCount(ThreeDigitNum answer, ThreeDigitNum input) {
        return new BallCount(answer, input);
    }

    @Override
    public String toString() {
        return String.format("%d%s", super.count, BALL_MESSAGE);
    }

    protected void updateCount() {
        for (int answerIdx = 0; answerIdx < answer.list().size(); ++answerIdx) {
            for (int inputIdx = 0; inputIdx < input.list().size(); ++inputIdx) {
                updateCountEach(answerIdx, inputIdx);
            }
        }
    }

    private void updateCountEach(int answerIdx, int inputIdx) {
        if (answerIdx == inputIdx) {
            return;
        }
        if (!isEqualValue(answer.list().get(answerIdx), input.list().get(inputIdx))) {
            return;
        }

        addCount();
    }
}
