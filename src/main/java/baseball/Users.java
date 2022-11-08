package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Users {
    private static final int INPUT_LENGTH = 3;

    private String input;


    public Users(String input) {
        CheckLength(input);
        CheckRange(input);
        CheckDuplicate(input);
        this.input = input;
    }

    public List<Integer> getInputList() {
        List<Integer> inputList = new ArrayList<>();
        for (int i = 0; i < this.input.length(); i++) {
            inputList.add(Integer.valueOf(String.valueOf(this.input.charAt(i))));
        }
        return inputList;
    }

    private void CheckRange(String input) {
        String pattern = "^[1-9]*$";
        if (!Pattern.matches(pattern, input)) throw new IllegalArgumentException();
    }

    private void CheckLength(String input) {
        if (input.length() != INPUT_LENGTH) throw new IllegalArgumentException();
    }

    private void CheckDuplicate(String input) {
        for (int i = 0; i < 3; i += 1) {
            int tmp = input.indexOf(input.charAt(i));
            if (tmp != i) throw new IllegalArgumentException();
        }
    }
}
