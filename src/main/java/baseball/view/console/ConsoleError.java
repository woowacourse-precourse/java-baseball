package baseball.view.console;

import baseball.view.ErrorView;

/**
 * 콘솔에 에러를 출력해주는 클래스
 */
public final class ConsoleError implements ErrorView {

    @Override
    public void printError(String content) {
        System.err.println(content);
    }
}
