package baseball.domain;

import static baseball.domain.count.BallCount.makeBallCount;
import static baseball.domain.count.StrikeCount.makeStrikeCount;

import baseball.domain.count.BallCount;
import baseball.domain.count.StrikeCount;

public class Hint {

    public static final String SPACE_MESSAGE = " ";
    public static final String NOTHING_MESSAGE = "낫싱";

    private StrikeCount strikeCount;
    private BallCount ballCount;

    public Hint(ThreeDigitNum answer, ThreeDigitNum input) {

        this.strikeCount = makeStrikeCount(answer, input);
        this.ballCount = makeBallCount(answer, input);
    }

    public boolean isAnswer() {
        return strikeCount.isAnswer();
    }

    @Override
    public String toString() {
        if (isAllCountEmpty()) {
            return NOTHING_MESSAGE;
        }

        return makeHintMsg(strikeCount.toString(), ballCount.toString());
    }

    private String makeHintMsg(String strikeMsg, String ballMsg) {
        StringBuffer stringBuffer = new StringBuffer();

        addBallMsg(ballMsg, stringBuffer);
        addSpaceMsg(stringBuffer);
        addStrikeMsg(strikeMsg, stringBuffer);

        return stringBuffer.toString();
    }

    private void addStrikeMsg(String strikeMsg, StringBuffer stringBuffer) {
        if (!strikeCount.isCountEmpty()) {
            stringBuffer.append(strikeMsg);
        }
    }

    private void addSpaceMsg(StringBuffer stringBuffer) {
        if (isAllCountExist()) {
            stringBuffer.append(SPACE_MESSAGE);
        }
    }

    private void addBallMsg(String ballMsg, StringBuffer stringBuffer) {
        if (!ballCount.isCountEmpty()) {
            stringBuffer.append(ballMsg);
        }
    }

    public boolean isAllCountExist() {
        return !(strikeCount.isCountEmpty() || ballCount.isCountEmpty());
    }

    public boolean isAllCountEmpty() {
        return strikeCount.isCountEmpty() && ballCount.isCountEmpty();
    }
}
