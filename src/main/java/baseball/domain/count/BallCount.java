package baseball.domain.count;

import baseball.domain.ThreeDigitNum;
import baseball.enums.CountMessage;

public class BallCount extends Count {

    public BallCount(ThreeDigitNum answer, ThreeDigitNum input) {
        super(answer, input);
    }

    public static BallCount makeBallCount(ThreeDigitNum answer, ThreeDigitNum input) {
        return new BallCount(answer, input);
    }

    @Override
    public String toString() {
        return String.format("%d%s", super.count, CountMessage.BALL.value());
    }

    @Override
    protected void update() {
        for (int answerIdx = 0; answerIdx < answer.list().size(); ++answerIdx) {
            for (int inputIdx = 0; inputIdx < input.list().size(); ++inputIdx) {
                updateEach(answerIdx, inputIdx);
            }
        }
    }

    private void updateEach(int answerIdx, int inputIdx) {
        if (answerIdx == inputIdx) {
            return;
        }
        if (!isEqualValue(answer.list().get(answerIdx), input.list().get(inputIdx))) {
            return;
        }

        add();
    }
}
