package baseball.domain;

import baseball.view.ErrorView;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Controller {
    private InputView inputView;
    private OutputView outputView;
    private ErrorView errorView;

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
            throw new IllegalArgumentException(e);
        }
    }

    private void printCommandInputMessage() {
        outputView.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
    }

    void initController() {
        outputView.print("숫자 야구 게임을 시작합니다.\n");
    }
}
