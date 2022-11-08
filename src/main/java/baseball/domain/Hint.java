package baseball.domain;

import static baseball.domain.count.CountManager.makeCountManager;

import baseball.domain.count.CountManager;
import baseball.enums.CountMessage;

public class Hint {

    private CountManager countManager;

    public Hint(ThreeDigitNum answer, ThreeDigitNum input) {

        this.countManager = makeCountManager(answer, input);
    }

    public boolean isAnswer() {
        return countManager.isAnswerCase();
    }

    @Override
    public String toString() {
        if (countManager.isAllCountZero()) {
            return CountMessage.NOTHING.value();
        }

        return makeHintMsg();
    }

    private String makeHintMsg() {
        StringBuffer stringBuffer = new StringBuffer();

        addBallMsg(countManager.ballMsg(), stringBuffer);
        addSpaceMsg(stringBuffer);
        addStrikeMsg(countManager.strikeMsg(), stringBuffer);

        return stringBuffer.toString();
    }

    private void addStrikeMsg(String strikeMsg, StringBuffer stringBuffer) {
        if (!countManager.isStrikeCountEmpty()) {
            stringBuffer.append(strikeMsg);
        }
    }

    private void addSpaceMsg(StringBuffer stringBuffer) {
        if (countManager.isAllCountExist()) {
            stringBuffer.append(CountMessage.SPACE.value());
        }
    }

    private void addBallMsg(String ballMsg, StringBuffer stringBuffer) {
        if (!countManager.isBallZero()) {
            stringBuffer.append(ballMsg);
        }
    }

}
