package baseball;

import java.util.List;

import static constant.Constants.*;

public class Score {
    //점수 계산 클래스
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

    //결과계산과 출력메서드
    public void calculateAndShowHint() {
        countResult();
        showHint();
    }

    //볼과 스트라이크 계산
    public void countResult() {
        ballCnt = strikeCnt = 0;
        for (int i = 0; i < ballSize; i++) {
            int computerNum = answer.get(i);
            int userNum = user.get(i);

            if (computerNum == userNum) strikeCnt++;
            else if (user.contains(computerNum)) ballCnt++;
        }
    }

    //계산된 결과 값 출력
    public void showHint() {
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

    //모든 숫자를 맞춘 경우 status 변경한다.
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
