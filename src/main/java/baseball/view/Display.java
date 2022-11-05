package baseball.view;

import static baseball.view.ViewConstants.*;

public class Display {
    public void printStartGame() {
        System.out.println(START_GAME);
    }

    public void printInputOffenseNumber() {
        System.out.println(INPUT);
    }

    public void printThreeStrike() {
        System.out.println(THREE_STRIKE);
    }

    public void printNothing() {
        System.out.println(NOTHING);
    }

    public void printBallAndStrike(int ballCount, int strikeCount) {
        System.out.println(String.format(X_BALL_X_STRIKE, ballCount, strikeCount));
    }

    public void printContinueGame() {
        System.out.println(CONTINUE_GAME);
    }


}
