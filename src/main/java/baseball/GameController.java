package baseball;

import baseball.number.GameNumber;
import baseball.printer.Printer;
import baseball.receiver.Receiver;
import baseball.result.Result;


public class GameController {
    private Receiver receiver;
    private Printer printer;
    private GameNumber gameNumber;
    private GameNumber randomNumber;
    private Result result;

    public GameController() {
        printer = new Printer();
        randomNumber = new GameNumber();
        receiver = new Receiver();
    }

    private void playGame(Result result) {
        while (!result.isCorrect()) {
            printer.requestNumber();
            gameNumber = new GameNumber(receiver.receiveUserNumber());
            result.countScore(randomNumber.getNumber(), gameNumber.getNumber());
            printer.printResult(result);
        }
    }

    public static boolean checkRestart(String restartNumber) {
        return restartNumber.equals("1") || restartNumber.equals("2");
    }

}
