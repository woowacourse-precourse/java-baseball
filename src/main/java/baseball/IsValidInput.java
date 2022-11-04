package baseball;

import java.util.HashSet;

public class IsValidInput {
    String input;
    boolean playing;

    IsValidInput(String input, boolean playing) {
        this.input = input;
        this.playing = playing;
    }

    boolean IsValidLength() {
        return ((playing) && (input.length() == 3)) || ((! playing) && (input.length()==1));
    }

    boolean IsValidValue() {
        if (! playing) {
            return input.equals("1") || input.equals("2");
        }
        HashSet<String> validNumber = ValidNumber();
        HashSet<String> inputSet = StringToSet();
        inputSet.retainAll(validNumber);
        return inputSet.size()==3;
    }

    HashSet<String> ValidNumber() {
        HashSet<String> validNumber = new HashSet<>();
        for(int i=1; i<=9; i++) {
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
