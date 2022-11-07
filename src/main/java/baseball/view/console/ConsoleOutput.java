package baseball.view.console;

import baseball.view.OutputView;

public class ConsoleOutput implements OutputView {

    @Override
    public void print(String content) {
        System.out.print(content);
    }
}
