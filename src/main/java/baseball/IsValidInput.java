package baseball;

import java.util.HashSet;

public class IsValidInput {
    String input;
    IsValidInput(String input) {
        this.input = input;
    }

    boolean IsValidLength(String input, boolean playing) {
        return ((playing) && (input.length() == 3)) || ((! playing) && (input.length()==1));
    }

    HashSet<String> StringToSet(String input) {
        HashSet<String> inputSet = new HashSet<>();
        for(int i=0; i<3; i++) {
            inputSet.add(String.valueOf(input.charAt(i)));
        }
        return inputSet;
    }
}
