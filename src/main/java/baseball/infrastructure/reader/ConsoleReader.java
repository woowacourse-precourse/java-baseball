package baseball.infrastructure.reader;

import baseball.application.io.Reader;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleReader implements Reader {

    @Override
    public String readLine() {
        return Console.readLine();
    }
}
