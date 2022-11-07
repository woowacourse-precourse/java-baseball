package baseball.view.console;

import baseball.view.OutputView;

/**
 * 콘솔에 출력을 하는 구현체
 */
public final class ConsoleOutput implements OutputView {

    @Override
    public void print(String content) {
        System.out.print(content);
    }
}
