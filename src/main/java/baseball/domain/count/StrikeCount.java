package baseball.domain.count;

import baseball.domain.ThreeDigitNum;

public class StrikeCount extends Count {

    public static final String STRIKE_MESSAGE = "스트라이크";

    public StrikeCount(ThreeDigitNum answer, ThreeDigitNum input) {
        super(answer, input);
    }

    public static StrikeCount makeStrikeCount(ThreeDigitNum answer, ThreeDigitNum input) {
        return new StrikeCount(answer, input);
    }

    @Override
    public String toString() {
        return String.format("%d%s", super.count, STRIKE_MESSAGE);
    }

    @Override
    protected void update() {
        for (int idx = 0; idx < answer.list().size(); ++idx) {
            updateEach(idx);
        }
    }


    private void updateEach(int idx) {
        if (!isEqualBirth(idx)) {
            return;
        }
        add();
    }

    public boolean isAnswer() {
        return super.count == 3;
    }

}
