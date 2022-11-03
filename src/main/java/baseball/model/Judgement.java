package baseball.model;

import java.util.List;

public class Judgement {
    private int strikeCnt;
    private int ballCnt;

    private void judgeStrike(User user, Computer computer) {
        strikeCnt = 0;
        List<Integer> userNumber = user.getUserInputNumber();
        List<Integer> computerNumber = computer.getRandomNumber();
        for (int i = 0; i < 3; i++) {
            if (userNumber.get(i) == computerNumber.get(i)) strikeCnt++;
        }
    }

    private void judgeBall(User user, Computer computer) {
        ballCnt = 0;
        List<Integer> userNumber = user.getUserInputNumber();
        List<Integer> computerNumber = computer.getRandomNumber();
        for (int i = 0; i < 3; i++) {
            if (userNumber.get(i) != computerNumber.get(i) && computerNumber.contains(userNumber.get(i))) ballCnt++;
        }
    }

    public boolean isNothing(User user, Computer computer) {
        judgeStrike(user, computer);
        judgeBall(user, computer);
        if (strikeCnt == 0 && ballCnt == 0) return true;
        return false;
    }

    public void cntClear() {
        strikeCnt = 0;
        ballCnt = 0;
    }

    public int getStrikeCnt() {
        return strikeCnt;
    }

    public int getBallCnt() {
        return ballCnt;
    }
}
