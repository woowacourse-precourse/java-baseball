package baseball.input;

import camp.nextstep.edu.missionutils.Console;

public class InputConsole implements InputAble {
    private final String ONLY_NUMBER = "숫자만 입력할 수 있습니다";
    @Override
    public int acceptInt() {
        try {
            String readLine = Console.readLine();
            return Integer.parseInt(readLine);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_NUMBER);
        }
    }
}
