package baseball.view;

import baseball.message.Messages;

public class Output {
    public static void printResult(int ballCount, int strileCount) {
        printBall(ballCount);
        printStrike(strileCount);
        printNothing(ballCount, strileCount);
        System.out.println();
    }

    private static void printNothing(int ballCount, int strileCount) {
        if (ballCount == 0 && strileCount == 0) {
            System.out.print(Messages.NOTHING);
        }
    }

    private static void printBall(int ballCount) {
        if(ballCount != 0) {
            System.out.printf(Messages.SPACE, ballCount, Messages.BALL);
        }
    }

    private static void printStrike(int strileCount) {
        if(strileCount != 0) {
            System.out.printf(Messages.SPACE, strileCount, Messages.STRIKE);
        }
    }
}
