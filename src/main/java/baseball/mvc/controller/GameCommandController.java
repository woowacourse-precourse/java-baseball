package baseball.mvc.controller;

import baseball.mvc.structure.enums.GameCommand;
import baseball.util.GameStatus;

public class GameCommandController {

    public GameStatus process(String playerCommandInput) {
        return GameCommand.commandGameStatus(playerCommandInput);
    }
}
