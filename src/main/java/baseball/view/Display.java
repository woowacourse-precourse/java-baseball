package baseball.view;

import static baseball.view.ViewConstants.*;

public class Print {
    public void startGame() {
        System.out.println(START_GAME);
    }

    public void inputOffenseNumber() {
        System.out.println(INPUT);
    }

    public void threeStrike() {
        System.out.println(THREE_STRIKE);
    }

    public void Nothing() {
        System.out.println(NOTHING);
    }

    public void printBallAndStrike(int ballCount, int strikeCount) {
        System.out.println(String.format(X_BALL_X_STRIKE, ballCount, strikeCount));
    }


}
