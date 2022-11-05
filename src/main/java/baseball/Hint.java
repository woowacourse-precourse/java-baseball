package baseball;

import java.util.List;

public class Hint {

    private int strikeCount;
    private int ballCount;

    public Hint(ThreeDigitNum answer, ThreeDigitNum input) {
        List<Integer> answerList = answer.list();
        List<Integer> inputList = input.list();

        strikeCount = 0;
        ballCount = 0;

        for (int i = 0; i < answerList.size(); ++i) {
            if (answerList.get(i).equals(inputList.get((i)))) {
                ++strikeCount;
            }
        }
        for (int i = 0; i < answerList.size(); ++i) {
            for (int j = 0; j < inputList.size(); ++j) {
                if (i != j && answerList.get(i).equals(inputList.get((j)))) {
                    ++ballCount;
                }
            }
        }
    }

    @Override
    public String toString() {
        if(strikeCount == 0 && ballCount == 0) {
            return "낫싱";
        }
        String strikeMsg = String.format("%d스트라이크", strikeCount);
        String ballMsg = String.format("%d볼", ballCount);

        String hintMsg = null;
        StringBuffer stringBuffer = new StringBuffer();
        if (!(ballCount == 0)) {
            stringBuffer.append(ballMsg);
        }
        if (!(strikeCount == 0 || ballCount == 0)) {
            stringBuffer.append(" ");
        }
        if(!(strikeCount == 0)) {
            stringBuffer.append(strikeMsg);
        }
        hintMsg = stringBuffer.toString();
        return hintMsg;
    }

    public boolean isAnswer() {
        return strikeCount == 3;
    }
}
