package baseball;

import java.util.HashSet;

import static baseball.Constant.*;

public class UserInput {
    private String input;
    private boolean playing;

    UserInput(String input, boolean playing) {
        this.input = input;
        this.playing = playing;
    }

    public boolean IsValid() {
        if (!playing && IsValidRestartOrEndGame()) {
            return true;
        }
        if (playing && IsValidGuessNumber() && IsValidLength()) {
            return true;
        }
        return false;
    }

    private boolean IsValidLength() {
        return input.length() == NUMBERS_LENGTH;
    }

    private boolean IsValidRestartOrEndGame() {
        return input.equals(RE_START_MESSAGE) || input.equals(QUIT_GAME_MESSAGE);
    }

    private boolean IsValidGuessNumber() {
        HashSet<String> setRange1To9 = SetRange1To9();
        HashSet<String> inputSet = StringToSet();
        inputSet.retainAll(setRange1To9);
        return inputSet.size() == NUMBERS_LENGTH;
    }

    private HashSet<String> SetRange1To9() {
        HashSet<String> setRange1To9 = new HashSet<>();
        for(int i=MIN_RANGE_NUMBER; i<=MAX_RANGE_NUMBER; i++) {
            setRange1To9.add(String.valueOf(i));
        }
        return setRange1To9;
    }

    private HashSet<String> StringToSet() {
        HashSet<String> inputSet = new HashSet<>();
        for(int i=0; i<NUMBERS_LENGTH; i++) {
            inputSet.add(String.valueOf(input.charAt(i)));
        }
        return inputSet;
    }
}
