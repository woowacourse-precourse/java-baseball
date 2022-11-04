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

    public void printResult() {
        String res = "";
        if (strikeCnt == 0 && ballCnt == 0) {
            res = "낫싱";
        }

        if (ballCnt != 0) {
            res = ballCnt + "볼 ";
        }

        if (strikeCnt != 0) {
            res += strikeCnt + "스트라이크";
        }

        System.out.println(res.trim());
    }
}
