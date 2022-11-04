package baseball;

import camp.nextstep.edu.missionutils.Console;

import static baseball.Constant.*;

public class Choice {
    public static String takeChoice() {
        return Console.readLine();
    }

    public static void checkChoice(String input) throws IllegalArgumentException {
        if (!input.equals(NEW_GAME) && !input.equals(QUIT))
            throw new IllegalArgumentException(GAME_FINISH);
    }
}
