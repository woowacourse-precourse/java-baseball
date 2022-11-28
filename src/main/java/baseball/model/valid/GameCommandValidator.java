package baseball.model.valid;

import baseball.util.GameCommandConst;

import java.util.List;

public class GameCommandValidator implements InputValidator {
    @Override
    public void validate(String input) throws IllegalArgumentException {
        List<String> gameCommands = List.of(GameCommandConst.RESTART, GameCommandConst.QUIT);
        if (!gameCommands.contains(input.strip())) {
            throw new IllegalArgumentException();
        }
    }
}
