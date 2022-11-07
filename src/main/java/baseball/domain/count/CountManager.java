package baseball.domain.count;

import static baseball.domain.count.BallCount.makeBallCount;
import static baseball.domain.count.StrikeCount.makeStrikeCount;

import baseball.domain.ThreeDigitNum;

public class CountManager {

    private StrikeCount strikeCount;
    private BallCount ballCount;

    public CountManager(ThreeDigitNum answer, ThreeDigitNum input) {
        this.strikeCount = makeStrikeCount(answer, input);
        this.ballCount = makeBallCount(answer, input);
    }

    public static CountManager makeCountManager(ThreeDigitNum answer, ThreeDigitNum input) {
        return new CountManager(answer, input);
    }

    public boolean isAnswerCase() {
        return strikeCount.isAnswer();
    }

    public String strikeMsg() {
        return strikeCount.toString();
    }
    public String ballMsg() {
        return ballCount.toString();
    }

    public boolean isAllCountExist() {
        return !(strikeCount.isZero() || ballCount.isZero());
    }

    public boolean isAllCountZero() {
        return strikeCount.isZero() && ballCount.isZero();
    }

    public boolean isStrikeCountEmpty() {
        return strikeCount.isZero();
    }
    public boolean isBallZero() {
        return ballCount.isZero();
    }
}
