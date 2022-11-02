package baseball.model;

import java.util.List;

public class Judgement {
    private int strikeCnt;
    private int ballCnt;

    public Judgement() {
        strikeCnt = 0;
        ballCnt = 0;
    }

    public void judgeStrike(User user, Computer computer) {
        setStrikeCntZero();
        List<Integer> userNumber = user.getUserInputNumber();
        List<Integer> computerNumber = computer.getRandomNumber();
        for (int i = 0; i < 3; i++) {
            if (userNumber.get(i) == computerNumber.get(i)) strikeCnt++;
        }
    }

    public void judgeBall(User user, Computer computer) {
        setBallCntZero();
        List<Integer> userNumber = user.getUserInputNumber();
        List<Integer> computerNumber = computer.getRandomNumber();
        for (int i = 0; i < 3; i++) {
            if (userNumber.get(i) != computerNumber.get(i) && computerNumber.contains(userNumber.get(i))) ballCnt++;
        }
    }

    public boolean judgeNothing(User user, Computer computer) {
        judgeStrike(user, computer);
        judgeBall(user, computer);
        if (strikeCnt == 0 && ballCnt == 0) return true;
        return false;
    }

    private void setStrikeCntZero() {
        strikeCnt = 0;
    }

    private void setBallCntZero() {
        ballCnt = 0;
    }
}
