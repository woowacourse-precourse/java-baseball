package baseball;

import baseball.number.GameNumber;
import baseball.printer.Printer;
import baseball.receiver.Receiver;
import baseball.result.Result;

import java.util.Scanner;

public class BaseBallGamePlayer {
    private final Printer printer;
    private final Receiver receiver;
    private Result result;
    private GameNumber computerNumber;
    private GameNumber userNumber;

    public BaseBallGamePlayer() {
        printer = new Printer();
        receiver = new Receiver();
        computerNumber = new GameNumber();
    }

    public void run() {
        printer.greet();

        while (true) {
            result = new Result(0, 0);

            playBall(result);


        }
    }

    public void playBall(Result result) {
        computerNumber.generateRandomNumber();

        while (!result.isOut()) {
            printer.requestUserNumber();

            userNumber = new GameNumber(receiver.receiveNumber());

            result.calculateBallCount(computerNumber.getGameNumber(), userNumber.getGameNumber());
            printer.printBallCount(result);
        }

        printer.printWin();
    }

    public void validate


}
