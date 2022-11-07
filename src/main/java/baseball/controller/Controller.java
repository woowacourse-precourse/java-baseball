package baseball.controller;

import baseball.game.Game;
import baseball.view.ErrorView;
import baseball.view.InputView;
import baseball.view.OutputView;

import static baseball.config.ControllerConstants.COMMAND_ERROR_MESSAGE;
import static baseball.config.ControllerConstants.COMMAND_INPUT_MESSAGE;
import static baseball.config.ControllerConstants.INIT_MESSAGE;

public final class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final ErrorView errorView;

    public Controller(InputView inputView, OutputView outputView, ErrorView errorView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.errorView = errorView;
        initController();
    }

    public void runGame(Game game) {
        CommandKey commandKey = CommandKey.RETRY;
        while (commandKey != CommandKey.FINISH) {
            game.play();
            commandKey = getCommandFromInput();
        }
    }

    private CommandKey getCommandFromInput() {
        try {
            printCommandInputMessage();
            String inputLine = inputView.readLine();
            int key = Integer.parseInt(inputLine);
            return CommandKey.from(key);
        } catch (IllegalArgumentException e) {
            errorView.printError(e.getMessage());
            throw new IllegalArgumentException(COMMAND_ERROR_MESSAGE, e);
        }
    }

    private void printCommandInputMessage() {
        outputView.print(COMMAND_INPUT_MESSAGE);
    }

    void initController() {
        outputView.print(INIT_MESSAGE);
    }
}
