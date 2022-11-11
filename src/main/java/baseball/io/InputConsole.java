package baseball.io;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputConsole implements Input{

    @Override
    public String scan() {
        return readLine();
    }
}
