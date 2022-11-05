package baseball.rule;

import baseball.exception.InputOutOfRangeException;

import java.util.Arrays;

public enum GameOption {

    PLAY(1, true),
    STOP(2, false);

    private final int option;
    private final boolean playable;

    GameOption(int option, boolean playable){
        this.option = option;
        this.playable = playable;
    }

    public static GameOption isCorrectOption(int input){
        return Arrays.stream(GameOption.values())
                .filter(gameOption -> gameOption.option == input)
                .findAny()
                .orElseThrow(InputOutOfRangeException::new);
    }

    public static boolean playOrStop(GameOption gameOption){
        return gameOption.playable;
    }
}
