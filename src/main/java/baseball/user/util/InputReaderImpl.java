package baseball.user.util;

import camp.nextstep.edu.missionutils.Console;

public class InputReaderImpl implements InputReader {

    @Override
    public String getInput() {
        return Console.readLine();
    }
}
