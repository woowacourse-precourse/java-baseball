package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    private final Exception exception = new Exception();

    public String getInput() {
        String input = Console.readLine();

        exception.checkIllegalGameInput(input);

        return input;
    }

    public boolean checkRestart() {
        String input = Console.readLine();

        exception.checkIllegalRestartInput(input);

        return input.equals("1");
    }
}
