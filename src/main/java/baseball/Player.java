package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    private final Exception exception = new Exception();

    public String getInput() {
        String input = Console.readLine();

        exception.checkIllegalInput(input);

        return input;
    }

    public boolean checkRestart() {
        String input = Console.readLine();

        return input.equals("1");
    }
}
