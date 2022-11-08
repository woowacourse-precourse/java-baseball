package baseball;

import baseball.controller.GameController;
import baseball.utils.resources.OutputMessage;
import baseball.utils.MessagePrinter;

public class Application {
    public static void main(String[] args) {
        MessagePrinter.printLine(OutputMessage.RUN_APPLICATION);
        try {
            GameController.runGame();
        } catch (IllegalArgumentException exception) {
            GameController.informExitByError(exception);
            throw new IllegalArgumentException();
        } catch (Exception exception) {
            GameController.informExitByError(exception);
        }
    }
}
