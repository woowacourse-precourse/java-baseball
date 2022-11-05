package baseball;

import java.util.List;

public class Hint {

    private int strikeCount;
    private int ballCount;

    public Hint(List<Integer> answer, List<Integer> input) {
        strikeCount = 0;
        ballCount = 0;

        for (int i = 0; i < answer.size(); ++i) {
            if (answer.get(i) == input.get((i))) {
                ++strikeCount;
            }
        }
        for (int i = 0; i < answer.size(); ++i) {
            for (int j = 0; j < input.size(); ++j) {
                if (i != j && answer.get(i) == input.get((j))) {
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

        String hintMsg = "";
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
