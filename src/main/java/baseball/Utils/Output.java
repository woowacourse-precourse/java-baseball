package baseball.Utils;

public class Output {

    private static String makeStrikeScore(int strikeCnt) {
        if (strikeCnt == 0) {
            return "";
        }
        return strikeCnt + "스트라이크 ";
    }

    private static String makeBallScore(int ballCnt) {
        if (ballCnt == 0) {
            return "";
        }
        return ballCnt + "볼 ";
    }

    public static String makeOutputString(int strikeCnt, int ballCnt) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeBallScore(ballCnt)).append(makeStrikeScore(strikeCnt));
        if (strikeCnt + ballCnt == 0) {
            return "낫싱";
        }
        return sb.toString().strip();
    }
}
