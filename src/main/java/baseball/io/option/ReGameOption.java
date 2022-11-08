package baseball.io.option;

import baseball.exception.InputWrongReGameNumberException;

import java.util.Arrays;

public enum ReGameOption {

    REGAME("1", true),
    END("2", false);

    private final String option;
    private boolean playAgain;

    ReGameOption(String option, boolean playAgain) {
        this.option = option;
        this.playAgain = playAgain;
    }

    public static ReGameOption checkValidateOption(String input) {
        return Arrays.stream(ReGameOption.values())
                .filter(gameOption -> gameOption.option.equals(input))
                .findAny()
                .orElseThrow(InputWrongReGameNumberException::new);
    }

    public static boolean reGameOrEndGame(ReGameOption reGameOption) {
        return reGameOption.playAgain;
    }


}
