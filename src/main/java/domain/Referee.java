package domain;

import java.util.List;

public class Referee {
    public static final String NOTHING = "낫싱";
    public static final String STRIKE = "스트라이크";
    public static final String BALL = "볼";

    public static int getResultStrike(List<Integer> computer, List<Integer> user) {
        int strikeCnt = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i) == user.get(i)) {
                strikeCnt++;
            }
        }
        return strikeCnt;
    }

    public static int getResultBall(List<Integer> computer, List<Integer> user) {
        int sameNumberCnt = 0;
        int ballCnt = 0;
        for (int computerNum : computer) {
            if (user.contains(computerNum)) {
                sameNumberCnt++;
            }
        }

        ballCnt = sameNumberCnt - getResultStrike(computer, user);
        return ballCnt;
    }

    public static String getJudgement(List<Integer> computer, List<Integer> user) {
        if (getResultBall(computer, user) == 0 && getResultStrike(computer, user) == 0) {
            return NOTHING;
        }
        if(getResultStrike(computer, user)==0){
            return getResultBall(computer, user) + BALL;
        }
        if(getResultBall(computer, user)==0){
            return getResultStrike(computer, user) + STRIKE;
        }
        return getResultBall(computer, user) + BALL + " " + getResultStrike(computer, user) + STRIKE;
    }

}