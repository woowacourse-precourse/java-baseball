package baseball.domain;

import java.util.List;

public class Hint {

    public static final String STRIKE_MESSAGE = "스트라이크";
    public static final String BALL_MESSAGE = "볼";
    public static final String SPACE_MESSAGE = " ";
    public static final String NOTHING_MESSAGE = "낫싱";

    private CountCheck countCheck;

    public Hint(ThreeDigitNum answer, ThreeDigitNum input) {
        List<Integer> answerList = answer.list();
        List<Integer> inputList = input.list();

        countCheck = new CountCheck();

        updateStrikeCount(answerList, inputList);
        updateBallCount(answerList, inputList);
    }
    public boolean isAnswer() {
        return countCheck.isAnswer();
    }

    @Override
    public String toString() {
        if (countCheck.isAllCountEmpty()) {
            return NOTHING_MESSAGE;
        }
        String strikeMsg = String.format("%d%s", countCheck.getStrikeCount(), STRIKE_MESSAGE);
        String ballMsg = String.format("%d%s", countCheck.getBallCount(), BALL_MESSAGE);

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
        if (answerIdx == inputIdx) {
            return;
        }
        if (!isEqualValue(answerList.get(answerIdx), inputList.get(inputIdx))) {
            return;
        }
        countCheck.addBallCount();
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
        countCheck.addStrikeCount();
    }

    private boolean isEqualBirth(List<Integer> answerList, List<Integer> inputList, int answerIdx) {
        return isEqualValue(answerList.get(answerIdx), inputList.get(answerIdx));
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
        if (!countCheck.isStrikeCountEmpty()) {
            stringBuffer.append(strikeMsg);
        }
    }

    private void addSpaceMsg(StringBuffer stringBuffer) {
        if (countCheck.isAllCountExist()) {
            stringBuffer.append(SPACE_MESSAGE);
        }
    }

    private void addBallMsg(String ballMsg, StringBuffer stringBuffer) {
        if (!countCheck.isBallCountEmpty()) {
            stringBuffer.append(ballMsg);
        }
    }
}
