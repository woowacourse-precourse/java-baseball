package baseball.utils;

import baseball.exception.InputOutOfOptionException;

import java.util.Arrays;

public enum GameOption {

    RESTART(1, true),
    FINISH(2, false);

    private final int option;
    private final boolean status;

    GameOption(int option, boolean status) {
        this.option = option;
        this.status = status;
    }

    public static GameOption isCorrectOption(int option) {
        return Arrays.stream(GameOption.values())
                .filter(gameOption -> gameOption.option == option)
                .findAny()
                .orElseThrow(InputOutOfOptionException::new);
    }

    public static boolean restartOrFinish(GameOption gameOption) {
        return gameOption.status;
    }
}
