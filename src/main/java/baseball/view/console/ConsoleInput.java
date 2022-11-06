package baseball.view.console;

import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput implements InputView {
    @Override
    public String readLine() {
        return Console.readLine();
    }
}
