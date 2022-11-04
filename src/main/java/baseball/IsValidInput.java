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

    boolean IsValidValue(String input, boolean playing) {
        if (! playing) {
            return input.equals("1") || input.equals("2");
        }
        HashSet<String> validNumber = ValidNumber();
        HashSet<String> inputSet = StringToSet(input);
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

    HashSet<String> StringToSet(String input) {
        HashSet<String> inputSet = new HashSet<>();
        for(int i=0; i<3; i++) {
            inputSet.add(String.valueOf(input.charAt(i)));
        }
        return inputSet;
    }
}
