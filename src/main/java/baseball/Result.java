package baseball;

import java.util.Arrays;
import java.util.List;

public class Result {
    private final int strikeCnt;
    private final int ballCnt;

    public Result(int strikeCnt, int ballCnt) {
        this.strikeCnt = strikeCnt;
        this.ballCnt = ballCnt;
    }

    public int getBallCnt() {
        return ballCnt;
    }

    public int getStrikeCnt() {
        return strikeCnt;
    }

    public static Result compareBall(String userInputNumber, String randomBall) {
        List <String> randomNumList = Arrays.asList(randomBall.split(""));

        int strike = 0;
        int ball = 0;
        int idx = 0;

        for (String digit : userInputNumber.split("")) {
            if (randomNumList.contains(digit) && digit.equals(randomNumList.get(idx))) {
                strike++;
                continue;
            }
            if (randomNumList.contains(digit)) {
                ball++;
                idx++;
            }
            idx++;
        }
        return new Result(strike, ball);
    }
}
