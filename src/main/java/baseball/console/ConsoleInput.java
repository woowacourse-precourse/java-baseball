package baseball.console;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

import static baseball.exception.ConsoleException.ANOTHER_GAME_INPUT_EXCEPTION;
import static baseball.exception.ConsoleException.BASEBALL_INPUT_EXCEPTION;

public class ConsoleInput {
    private static final Pattern BASEBALL_REGEX = Pattern.compile("^[1-9]{3}$");
    private static final Pattern ANOTHER_GAME_REGEX = Pattern.compile("^[1-2]$");

    public String readBaseBall() {
        String baseball = Console.readLine();
        if (!BASEBALL_REGEX.matcher(baseball).find()) {
            throw new IllegalArgumentException(BASEBALL_INPUT_EXCEPTION.getMessage());
        }
        return baseball;
    }

    public int readAnotherGame() {
        String type = Console.readLine();
        if (!ANOTHER_GAME_REGEX.matcher(type).find()) {
            throw new IllegalArgumentException(ANOTHER_GAME_INPUT_EXCEPTION.getMessage());
        }
        return Integer.parseInt(type);
    }
}
