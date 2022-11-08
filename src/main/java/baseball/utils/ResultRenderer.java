package baseball.utils;

public class ResultRenderer {
    public static String getResult(int strike, int ball) {
        String ballResult = getBallResult(ball);
        String strikeResult = getStrikeResult(strike);

        if (!ballResult.equals("") && !strikeResult.equals("")) {
            return ballResult + " " + strikeResult;
        } else if(!ballResult.equals("")) {
            return ballResult;
        }
        else if (!strikeResult.equals("")) {
            return strikeResult;
        } else {
            return "낫싱";
        }
    }

    private static String getStrikeResult(int strike) {
        if (strike != 0) {
            return strike + "스트라이크";
        }
        return "";
    }

    private static String getBallResult(int ball) {
        if (ball != 0) {
            return ball + "볼";
        }
        return "";
    }
}
