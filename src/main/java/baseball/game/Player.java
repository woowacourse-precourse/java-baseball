package baseball.game;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    private final String INPUT_NUMBER;

    public Player() {
        INPUT_NUMBER = Console.readLine().trim();
    }

    public String getINPUT_NUMBER() {
        return INPUT_NUMBER;
    }
}
