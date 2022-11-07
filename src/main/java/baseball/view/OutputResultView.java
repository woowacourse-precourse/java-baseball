package baseball.view;

public class OutputResultView {
    public static void printResult(int ballScore, int strikeScore) {
        printBall(ballScore);
        makeSpace(ballScore);
        printStrike(strikeScore);
        printNothing(ballScore, strikeScore);
        System.out.println();
    }

    private static void makeSpace(int ballScore) {
        if (ballScore != 0)
            System.out.print(' ');
    }

    private static void printStrike(int strikeScore) {
        if (strikeScore != 0)
            System.out.print(strikeScore + "스트라이크");

    }

    private static void printBall(int ballScore) {
        if (ballScore != 0)
            System.out.print(ballScore + "볼");
    }

    private static void printNothing(int ballScore, int strikeScore) {
        if (ballScore == 0 && strikeScore == 0)
            System.out.print("낫싱");
    }

    public static void printWinMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printEndMessage() {
        System.out.println("게임 종료");
    }
}
