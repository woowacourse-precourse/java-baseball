package baseball.game;

public class BaseballResult {

    public static int ballNum;
    public int strikeNum;

    private void showBallResult() {
        if (ballNum < 4 && ballNum > 0 && strikeNum < 3)
            System.out.print(ballNum + "볼");
    }

    private void showStrikeResult() {
        if (strikeNum != 0)
            System.out.print(strikeNum + "스트라이크");
    }

    private void showNothingResult() {
        if (strikeNum == 0 && ballNum == 0)
            System.out.print("낫싱");
    }

    private void showSpaceResult() {
        if (ballNum < 4 && ballNum > 0 && strikeNum != 0 && strikeNum != 3)
            System.out.print(" ");
    }

    public void showGameResult() {
        showBallResult();
        showSpaceResult();
        showStrikeResult();
        showNothingResult();
        System.out.println();
    }
}
