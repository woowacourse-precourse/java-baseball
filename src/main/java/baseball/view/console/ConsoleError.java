package baseball.view.console;

import baseball.view.ErrorView;

public final class ConsoleError implements ErrorView {

    @Override
    public void printError(String content) {
        System.err.println(content);
    }
}
