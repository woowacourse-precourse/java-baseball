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
        result = new Result(0,0);
    }

}
