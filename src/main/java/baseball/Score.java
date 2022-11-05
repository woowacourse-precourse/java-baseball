package baseball;

import java.util.List;

import static constant.Constants.*;

public class Score {
    int ballCnt = 0;
    int strikeCnt = 0;
    List<Integer> answer;
    List<Integer> user;

    public Score(List<Integer> answer, List<Integer> user) {
        this.answer = answer;
        this.user = user;
    }


    public void countResult() {
        for (int i = 0; i < ballSize; i++) {
            int cpNum = answer.get(i);
            int userNum = user.get(i);

            if (cpNum == userNum) strikeCnt++;
            else if (user.contains(cpNum)) ballCnt++;
        }

    }

    public void showResult() {
        StringBuilder result = new StringBuilder();
        if (ballCnt == 0 && strikeCnt == 0) {
            System.out.println(NOTHING);
        }
        else {
            if (ballCnt > 0) result.append(ballCnt).append(BALL);
            if (strikeCnt > 0) result.append(strikeCnt).append(STRIKE);
        }
        System.out.println(result.toString().trim());
    }


    public Status checkingStatus() {
        if (strikeCnt == ballSize) return Status.End;
        else return Status.Playing;
    }
}
