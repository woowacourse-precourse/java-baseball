package baseball;

import java.util.HashSet;

import static baseball.Constant.*;

public class UserInput {
    String input;
    boolean playing;

    UserInput(String input, boolean playing) {
        this.input = input;
        this.playing = playing;
    }

    public boolean IsValid() {
        if (IsValidGuessNumber()) {
            return true;
        }
        if (IsValidGuessNumber()) {
            return true;
        }
        return false;
    }

    boolean IsValidLength() {
        return ((playing) && (input.length() == NUMBERS_LENGTH));
    }

    boolean IsValidRestartOrEndGame() {
        return input.equals(RE_START_MESSAGE) || input.equals(QUIT_GAME_MESSAGE);
    }

    boolean IsValidGuessNumber() {
        HashSet<String> setRange1To9 = SetRange1To9();
        HashSet<String> inputSet = StringToSet();
        inputSet.retainAll(setRange1To9);
        return inputSet.size() == NUMBERS_LENGTH;
    }

    HashSet<String> SetRange1To9() {
        HashSet<String> setRange1To9 = new HashSet<>();
        for(int i=MIN_RANGE_NUMBER; i<=MAX_RANGE_NUMBER; i++) {
            setRange1To9.add(String.valueOf(i));
        }
        return setRange1To9;
    }

    HashSet<String> StringToSet() {
        HashSet<String> inputSet = new HashSet<>();
        for(int i=0; i<3; i++) {
            inputSet.add(String.valueOf(input.charAt(i)));
        }
        return inputSet;
    }
}
