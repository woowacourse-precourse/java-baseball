package baseball.view;

import baseball.utils.KeyboardReader;
import baseball.utils.MessagePrinter;
import baseball.utils.resources.InputKey;
import baseball.utils.resources.OutputMessage;
import baseball.model.Result;

public class GameView {
    private GameView() { }
    private static final GameView instance = new GameView();
    public static GameView getInstance() {
        return instance;
    }

    public void showExitMessageByError(Exception exception) {
        if (exception.getMessage() != null) {
            MessagePrinter.printLine("\n" + exception.getMessage());
        }
        MessagePrinter.printLine(OutputMessage.EXIT_BY_ERROR);
    }

    public String askGuessingNumbers() throws IllegalArgumentException {
        MessagePrinter.print(OutputMessage.GUESS_COMPUTER_NUMBERS);
        return KeyboardReader.readLineOnlyInteger();
    }

    public void showHintByResult(Result guessResult) {
        MessagePrinter.printLine(guessResult.generateHintMessage());
    }

    public boolean askRestartGame() throws IllegalArgumentException {
        MessagePrinter.printLine(OutputMessage.PLAYER_WIN);
        MessagePrinter.printLine(OutputMessage.RESTART_OR_QUIT);
        return KeyboardReader.readLineAsBooleanKey(InputKey.RESTART, InputKey.QUIT);
    }
}
