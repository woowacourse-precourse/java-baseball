package baseball;

import baseball.number.GameNumber;
import baseball.printer.Printer;
import baseball.receiver.Receiver;
import baseball.result.Result;

public class BaseBallGamePlayer {
    private static final String RESTART_NUMBER = "1";
    private static final String ESCAPE_NUMBER = "2";
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
        String restartNumber = "1";
        printer.greet();

        while (restartNumber == "1") {
            result = new Result(0, 0);

            playBall(result);
            restartNumber = receiver.receiveRestartNumber();
        }
    }


    private void playBall(Result result) {
        computerNumber.generateRandomNumber();

        while (!result.isOut()) {
            printer.requestUserNumber();

            userNumber = new GameNumber(receiver.receiveUserNumber());

            result.calculateBallCount(computerNumber.getGameNumber(), userNumber.getGameNumber());
            printer.printBallCount(result);
        }

        printer.printWin();
    }

    public static boolean isValidRestartNumber(String restartNumber) {
        return (restartNumber == RESTART_NUMBER || restartNumber == ESCAPE_NUMBER);
    }


}
