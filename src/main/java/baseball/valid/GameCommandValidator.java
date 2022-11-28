package baseball.valid;

import baseball.util.message.ExceptionMessage;
import baseball.util.GameCommandConst;

import java.util.List;

public class GameCommandValidator implements InputValidator {
    @Override
    public void validate(String input) throws IllegalArgumentException {
        List<String> gameCommands = List.of(GameCommandConst.RESTART, GameCommandConst.QUIT);
        if (!gameCommands.contains(input.strip())) {
            String message = ExceptionMessage.READ_INVALID_GAME_COMMAND_ERROR.getMessage();
            throw new IllegalArgumentException(message);
        }
    }
}
