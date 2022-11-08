package baseball;

import java.util.List;

class Hint {
    private static final String NOTHING = "낫싱";
    private static final String STRIKE = "%s스트라이크";
    private static final String BALL = "%s볼";
    private static final String STRIKE_AND_BALL = "%s볼 %s스트라이크";

    private List<Integer> answerList;
    private int strikeCnt = 0;
    private int ballCnt = 0;

    public Hint(List<Integer> answerList) {
        this.answerList = answerList;
    }

    public String retrieve(List<Integer> guess) {
        countStrikeAndBall(guess);
        if (strikeCnt == 0 && ballCnt == 0) {
            return NOTHING;
        }
        if (strikeCnt > 0 && ballCnt == 0) {
            return String.format(STRIKE, strikeCnt);
        }
        if (strikeCnt == 0 && ballCnt > 0) {
            return String.format(BALL, ballCnt);
        }
        return String.format(STRIKE_AND_BALL, ballCnt, strikeCnt);
    }

    private void countStrikeAndBall(List<Integer> guess) {
        strikeCnt = 0;
        ballCnt = 0;

        for (int i = 0; i < Game.MAX_ANSWER_SIZE; i++) {
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
