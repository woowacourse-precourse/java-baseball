package baseball;

import java.util.List;

import static constant.Constants.*;

public class Score {

    private int ballCnt = 0;
    private int strikeCnt = 0;
    private List<Integer> answer;
    private List<Integer> user;

    public void setAnswerNums(List<Integer> answer) {
        this.answer = answer;
    }

    public void setUserNums(List<Integer> user) {
        this.user = user;
    }

    public void calculateAndShowResult() {
        countResult();
        showResult();
    }

    public void countResult() {
        ballCnt = strikeCnt = 0;
        for (int i = 0; i < ballSize; i++) {
            int computerNum = answer.get(i);
            int userNum = user.get(i);

            if (computerNum == userNum) strikeCnt++;
            else if (user.contains(computerNum)) ballCnt++;
        }
    }

    public void showResult() {
        StringBuilder result = new StringBuilder();
        if (ballCnt == 0 && strikeCnt == 0) {
            result.append(NOTHING);
        }
        else {
            if (ballCnt > 0) result.append(ballCnt).append(BALL);
            if (strikeCnt > 0) result.append(strikeCnt).append(STRIKE);
        }
        System.out.println(result.toString().trim());

    }

    //모든 숫자를 맞춘 경우 status 를 변경한다.
    public Status checkingStatus() {
        if (strikeCnt == ballSize) return Status.End;
        else return Status.Playing;
    }

    public int getBallCnt() {
        return ballCnt;
    }

    public int getStrikeCnt() {
        return strikeCnt;
    }
}
