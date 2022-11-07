package baseball.view.console;

import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Console;

/**
 * 콘솔에서부터 입력을 받는 구현체
 */
public final class ConsoleInput implements InputView {
    @Override
    public String readLine() {
        return Console.readLine();
    }
}
