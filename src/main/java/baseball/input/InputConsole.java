package baseball.input;

import camp.nextstep.edu.missionutils.Console;

public class InputConsole implements InputAble {
    @Override
    public int acceptInt() {
        String readLine = Console.readLine();
        IntInputNumber intInputNumber = new IntInputNumber(readLine);
        return intInputNumber.getIntInputNumber();
    }
}
