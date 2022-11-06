package baseball;

public class GuessResult {
    int ballCount;
    int strikeCount;

    public GuessResult(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public static boolean isNothing(int ballCount, int strikeCount) {
        return ballCount == 0 && strikeCount == 0;
    }

    public static void guessResultPrint(int ballCount, int strikeCount) {
        String guessResult = "";
        if (isNothing(ballCount, strikeCount)) {
            guessResult += "낫싱";
        }
        if (ballCount > 0) {
            guessResult += ballCount + "볼 ";
        }
        if (strikeCount > 0) {
            guessResult += strikeCount + "스트라이크";
        }
        System.out.println(guessResult);
    }
}
