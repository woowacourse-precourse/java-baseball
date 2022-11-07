package baseball.view.console;

import baseball.view.OutputView;

public final class ConsoleOutput implements OutputView {

    @Override
    public void print(String content) {
        System.out.print(content);
    }
}
