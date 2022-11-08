package baseball.model;

import camp.nextstep.edu.missionutils.Console;

public class RestartGame {
    public boolean restartorExit() throws IllegalArgumentException {
        String input = Console.readLine();

        if((!input.equals("1")) && (!input.equals("2"))) throw new IllegalArgumentException();

        return input.equals("1");
    }

}

