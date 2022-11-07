package utils;

public class Output {

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
            return ballCount + "볼 ";
        }
        return "";
    }

    private static String getStrikeResult(int strikeCount) {
        if (strikeCount > 0) {
            return strikeCount + "스트라이크";
        }
        return "";
    }

    private static String getNottingResult(String result) {
        if (result.length() == 0) {
            return "낫싱";
        }
        return result;
    }

    public static void doneGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
