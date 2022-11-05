package baseball;

import fixed.FixedList;

public class AnswerChecker {
    private final int[] answer;
    private int strikeCnt;
    private int ballCnt;

    public AnswerChecker(int[] answer) {
        this.answer = answer;
        this.strikeCnt = 0;
        this.ballCnt = 0;
    }

    public void checkStrikeOrBall(int[] userInput) {
        for (int i = 0; i < FixedList.LENGTH; i++){
            checkStrike(answer[i], userInput[i]);
        }
    }

    public void checkStrike(int answerNum, int inputNum) {
        if (answerNum == inputNum) {
            strikeCnt++;
            return;
        }
        checkBall(inputNum);
    }

    public void checkBall (int inputNum) {
        for (int i = 0; i < FixedList.LENGTH; i++) {
            if (answer[i] == inputNum) {
                ballCnt++;
                return;
            }
        }
    }

    public boolean isAnswer () {
        return strikeCnt == 3;
    }

    public int getBallCnt() {
        return ballCnt;
    }

    public int getStrikeCnt() {
        return strikeCnt;
    }
}