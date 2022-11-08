package baseball;

import java.util.List;

import static baseball.HintMessage.*;

class Hint {
    private List<Integer> answerList;
    private int strikeCnt = 0;
    private int ballCnt = 0;

    public Hint(List<Integer> answerList) {
        this.answerList = answerList;
    }

    public String retrieve(List<Integer> guess) {
        countStrikeAndBall(guess);
        if (strikeCnt == 0 && ballCnt == 0) {
            return NOTHING.message();
        }
        if (strikeCnt > 0 && ballCnt == 0) {
            return String.format(STRIKE.message(), strikeCnt);
        }
        if (strikeCnt == 0 && ballCnt > 0) {
            return String.format(BALL.message(), ballCnt);
        }
        return String.format(STRIKE_AND_BALL.message(), ballCnt, strikeCnt);
    }

    private void countStrikeAndBall(List<Integer> guess) {
        strikeCnt = 0;
        ballCnt = 0;

        for (int i = 0; i < Game.ANSWER_SIZE; i++) {
            if (answerList.get(i).equals(guess.get(i))) {
                strikeCnt++;
                continue;
            }
            if (answerList.contains(guess.get(i))) {
                ballCnt++;
            }
        }
    }
}
