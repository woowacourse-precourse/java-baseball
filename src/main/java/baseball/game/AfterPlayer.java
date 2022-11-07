package baseball.game;

import camp.nextstep.edu.missionutils.Console;

public class AfterPlayer {
    private final String CONTINUE_NUMBER;
    public AfterPlayer() {
        CONTINUE_NUMBER = Console.readLine().trim();
    }

    public String getCONTINUE_NUMBER() {
        return CONTINUE_NUMBER;
    }
}
