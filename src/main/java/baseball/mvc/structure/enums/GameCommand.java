package baseball.mvc.structure.enums;

import baseball.util.GameStatus;
import java.util.Arrays;

public enum GameCommand {
    NEW_GAME("1", GameStatus.START),

    EXIT("2", GameStatus.EXIT);

    private static final String WRONG_INPUT = "잘못된 입력입니다.";

    private final String command;
    private final GameStatus gameStatus;

    GameCommand(String command, GameStatus gameStatus) {
        this.command = command;
        this.gameStatus = gameStatus;
    }

    public static GameStatus commandGameStatus(String inputCommand) {
        return Arrays.stream(GameCommand.values())
                .filter(gameCommand -> gameCommand.command.equals(inputCommand))
                .findAny()
                .map(gameCommand -> gameCommand.gameStatus)
                .orElseThrow(() -> new IllegalArgumentException(WRONG_INPUT));
    }
}
