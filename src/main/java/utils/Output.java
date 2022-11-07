package utils;

public class Output {
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTTING = "낫싱";

    private Output() {}

    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void getResult(int ballCount, int strikeCount) {
        String result = "";
        result += getBallResult(ballCount);
        result += getStrikeResult(strikeCount);
        result = getNottingResult(result);
        System.out.println(result);
    }

    private static String getBallResult(int ballCount) {
        if (ballCount > 0) {
            return ballCount + BALL + " ";
        }
        return "";
    }

    private static String getStrikeResult(int strikeCount) {
        if (strikeCount > 0) {
            return strikeCount + STRIKE;
        }
        return "";
    }

    private static String getNottingResult(String result) {
        if (result.length() == 0) {
            return NOTTING;
        }
        return result;
    }

    public static void doneGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void endGame() {
        System.out.println("게임 종료");
    }
}
