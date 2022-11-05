package baseball.domain;

import java.util.List;

public class Hint {

    public static final String STRIKE_MESSAGE = "스트라이크";
    public static final String BALL_MESSAGE = "볼";
    public static final String SPACE_MESSAGE = " ";
    private int strikeCount;
    private int ballCount;

    public Hint(ThreeDigitNum answer, ThreeDigitNum input) {
        List<Integer> answerList = answer.list();
        List<Integer> inputList = input.list();

        strikeCount = 0;
        ballCount = 0;

        updateStrikeCount(answerList, inputList);
        updateBallCount(answerList, inputList);
    }

    @Override
    public String toString() {
        if (isAllCountEmpty()) {
            return "낫싱";
        }
        String strikeMsg = String.format("%d%s", strikeCount, STRIKE_MESSAGE);
        String ballMsg = String.format("%d%s", ballCount, BALL_MESSAGE);

        return makeHintMsg(strikeMsg, ballMsg);
    }

    private void updateBallCount(List<Integer> answerList, List<Integer> inputList) {
        for (int answerIdx = 0; answerIdx < answerList.size(); ++answerIdx) {
            for (int inputIdx = 0; inputIdx < inputList.size(); ++inputIdx) {
                updateBallCountEach(answerList, inputList, answerIdx, inputIdx);
            }
        }
    }

    private void updateBallCountEach(List<Integer> answerList, List<Integer> inputList, int answerIdx, int inputIdx) {
        if (isEqualBirth(answerIdx, inputIdx)) {
            return;
        }
        if (!isEqualValue(answerList.get(answerIdx), inputList.get(inputIdx))) {
            return;
        }
        addBallCount(answerList.get(answerIdx), inputList.get(inputIdx));
    }

    private void addBallCount(Integer answerDigit, Integer inputDigit) {
        ++ballCount;
    }

    private void updateStrikeCount(List<Integer> answerList, List<Integer> inputList) {
        for (int answerIdx = 0; answerIdx < answerList.size(); ++answerIdx) {
            updateStrikeCountEach(answerList, inputList, answerIdx);
        }
    }

    private void updateStrikeCountEach(List<Integer> answerList, List<Integer> inputList, int answerIdx) {
        if (!isEqualBirth(answerList, inputList, answerIdx)) {
            return;
        }
        addStrikeCount();
    }

    private void addStrikeCount() {
        ++strikeCount;
    }

    private boolean isEqualBirth(List<Integer> answerList, List<Integer> inputList, int answerIdx) {
        return isEqualValue(answerList.get(answerIdx), inputList.get(answerIdx));
    }

    private boolean isEqualBirth(int answerIdx, int inputIdx) {
        return answerIdx == inputIdx;
    }


    private boolean isEqualValue(Integer answerDigit, Integer inputDigit) {
        return answerDigit.equals(inputDigit);
    }


    private String makeHintMsg(String strikeMsg, String ballMsg) {
        StringBuffer stringBuffer = new StringBuffer();

        addBallMsg(ballMsg, stringBuffer);
        addSpaceMsg(stringBuffer);
        addStrikeMsg(strikeMsg, stringBuffer);

        return stringBuffer.toString();
    }

    private void addStrikeMsg(String strikeMsg, StringBuffer stringBuffer) {
        if (!isStrikeCountEmpty()) {
            stringBuffer.append(strikeMsg);
        }
    }

    private void addSpaceMsg(StringBuffer stringBuffer) {
        if (isAllCountExist()) {
            stringBuffer.append(SPACE_MESSAGE);
        }
    }

    private void addBallMsg(String ballMsg, StringBuffer stringBuffer) {
        if (!isBallCountEmpty()) {
            stringBuffer.append(ballMsg);
        }
    }

    private boolean isAllCountExist() {
        return !(isStrikeCountEmpty() || isBallCountEmpty());
    }

    private boolean isAllCountEmpty() {
        return isStrikeCountEmpty() && isBallCountEmpty();
    }

    private boolean isBallCountEmpty() {
        return ballCount == 0;
    }

    private boolean isStrikeCountEmpty() {
        return strikeCount == 0;
    }

    public boolean isAnswer() {
        return strikeCount == 3;
    }
}
