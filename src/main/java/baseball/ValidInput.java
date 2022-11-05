package baseball;

import java.util.HashSet;

import static baseball.Constant.*;

public class ValidInput {
    String input;
    boolean playing;

    ValidInput(String input, boolean playing) {
        this.input = input;
        this.playing = playing;
    }

    boolean IsValidLength() {
        return ((playing) && (input.length() == PLAYING_NUMBERS_LENGTH));
    }

    boolean IsValidRestartOrEndGame() {
        return input.equals(RE_START_MESSAGE) || input.equals(END_GAME_MESSAGE);
    }

    boolean IsValidValue() {
        HashSet<String> validNumber = ValidNumber();
        HashSet<String> inputSet = StringToSet();
        inputSet.retainAll(validNumber);
        return inputSet.size()==PLAYING_NUMBERS_LENGTH;
    }

    HashSet<String> ValidNumber() {
        HashSet<String> validNumber = new HashSet<>();
        for(int i=MIN_RANGE_NUMBER; i<=MAX_RANGE_NUMBER; i++) {
            validNumber.add(String.valueOf(i));
        }
        return validNumber;
    }

    HashSet<String> StringToSet() {
        HashSet<String> inputSet = new HashSet<>();
        for(int i=0; i<3; i++) {
            inputSet.add(String.valueOf(input.charAt(i)));
        }
        return inputSet;
    }
}
