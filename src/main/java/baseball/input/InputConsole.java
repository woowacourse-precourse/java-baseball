package baseball.input;

import camp.nextstep.edu.missionutils.Console;

public class InputConsole implements InputAble {
    @Override
    public int acceptInt() {
        try {
            String readLine = Console.readLine();
            return Integer.parseInt(readLine);
        } catch (NumberFormatException e) {
            throw new IllegalStateException("숫자를 입력해 주세요");
        }
    }
}
