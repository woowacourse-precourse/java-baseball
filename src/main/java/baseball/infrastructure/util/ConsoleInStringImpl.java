package baseball.infrastructure.util;

import baseball.domain.ConsoleInString;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleInStringImpl implements ConsoleInString {

    @Override
    public String inputString() {
        return Console.readLine();
    }
}
