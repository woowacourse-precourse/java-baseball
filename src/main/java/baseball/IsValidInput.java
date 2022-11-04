package baseball;

public class IsValidInput {
    String input;
    IsValidInput(String input) {
        this.input = input;
    }

    boolean IsValidLength(String input, boolean playing) {
        return ((playing) && (input.length() == 3)) || ((! playing) && (input.length()==1));
    }
}
