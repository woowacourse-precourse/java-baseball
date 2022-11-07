package baseball.view;

public class Output {
    public static void printResult(int ballCount, int strileCount) {
        printBall(ballCount);
        printStrike(strileCount);
        printNothing(ballCount, strileCount);
        System.out.println();
    }

    private static void printNothing(int ballCount, int strileCount) {
        if (ballCount == 0 && strileCount == 0) {
            System.out.print("낫싱");
        }
    }

    private static void printBall(int ballCount) {
        if(ballCount != 0) {
            System.out.printf("%d%s ", ballCount, "볼");
        }
    }

    private static void printStrike(int strileCount) {
        if(strileCount != 0) {
            System.out.printf("%d%s ", strileCount, "스트라이크");
        }
    }
}
