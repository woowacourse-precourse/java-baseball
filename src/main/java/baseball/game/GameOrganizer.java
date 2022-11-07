package baseball.game;

import baseball.console.ConsoleInput;
import baseball.console.ConsoleOutput;

import java.util.Optional;

import static baseball.exception.GameException.GAME_STATUS_NULL_EXCEPTION;
import static baseball.game.GameStatus.findGameStatus;

public class GameOrganizer {
    private final ConsoleInput consoleInput;
    private final ConsoleOutput consoleOutput;

    public GameOrganizer(ConsoleInput consoleInput, ConsoleOutput consoleOutput) {
        this.consoleInput = consoleInput;
        this.consoleOutput = consoleOutput;
    }

    public GameStatus askAnotherGame() {
        consoleOutput.printExplainAnotherGame();
        int gameStatusType = consoleInput.readAnotherGame();

        Optional<GameStatus> gameStatus = findGameStatus(gameStatusType);
        if (gameStatus.isEmpty()) {
            throw new NullPointerException(GAME_STATUS_NULL_EXCEPTION.getMessage());
        }

        return gameStatus.get();
    }
}
