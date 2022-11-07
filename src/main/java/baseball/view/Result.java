package baseball.view;

import static baseball.view.PrintMessage.*;

public class Result {
    public void printBall(int ball) {
        System.out.print(ball + BALL.getMessage() + " ");
    }

    public void printBallAndStrike(int ball, int strike) {
        System.out.println(ball + BALL.getMessage() + " " + strike + STRIKE.getMessage());
    }

    public void printNothing() {
        System.out.println(NOTHING.getMessage());
    }

    public void printStrike(int strike) {
        System.out.println(strike + STRIKE.getMessage());
    }

    public void printSuccess() {
        System.out.println(SUCCESS.getMessage());
    }
}
