package baseball;

import java.util.List;

public class AnswerChecker {
    private final List<Integer> answer;
    private int strikeCnt;
    private int ballCnt;

    public AnswerChecker(List<Integer> answer) {
        this.answer = answer;
        this.strikeCnt = 0;
        this.ballCnt = 0;
    }

    public void checkStrikeOrBall(List<Integer> userInput) {
        for (int i = 0; i < answer.size(); i++) {
            checkStrike(answer.get(i), userInput.get(i));
        }
    }

    public void checkStrike(int answerNum, int inputNum) {
        if (answerNum == inputNum) {
            strikeCnt++;
            return;
        }
        checkBall(inputNum);
    }

    public void checkBall(int inputNum) {
        for (Integer i : answer) {
            if (i == inputNum) {
                ballCnt++;
                return;
            }
        }
    }

    public boolean isAnswer() {
        return strikeCnt == 3;
    }

    public int getBallCnt() {
        return ballCnt;
    }

    public int getStrikeCnt() {
        return strikeCnt;
    }
}