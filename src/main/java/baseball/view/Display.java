package baseball.view;

import static baseball.view.ViewConstants.*;

public class Display {
    private Display() {
    }

    public static Display getInstance() {
        return new Display();
    }

    public void printStartGame() {
        System.out.println(START_GAME);
    }

    public void printInputOffenseNumber() {
        System.out.print(INPUT);
    }

    public void printThreeStrike() {
        System.out.println(THREE_STRIKE);
    }

    public void printNothing() {
        System.out.println(NOTHING);
    }

    public void printBallOnly(int ballCount) {
        System.out.println(String.format(BALL, ballCount));
    }

    public void printStrikeOnly(int strikeCount) {
        System.out.println(String.format(STRIKE, strikeCount));
    }

    public void printBallAndStrike(int ballCount, int strikeCount) {
        System.out.println(String.format(BALL_AND_STRIKE, ballCount, strikeCount));
    }

    public void printContinueGame() {
        System.out.println(CONTINUE_GAME);
    }
}
