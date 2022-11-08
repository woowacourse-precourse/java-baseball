package baseball;

import java.util.List;

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
            return "낫싱";
        }
        if (strikeCnt > 0 && ballCnt == 0) {
            return String.format("%s스트라이크", strikeCnt);
        }
        if (strikeCnt == 0 && ballCnt > 0) {
            return String.format("%s볼", ballCnt);
        }
        return String.format("%s볼 %s스트라이크", ballCnt, strikeCnt);
    }

    private void countStrikeAndBall(List<Integer> guess) {
        strikeCnt = 0;
        ballCnt = 0;

        for (int i = 0; i < 3; i++) {
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
