package baseball;

import java.util.ArrayList;
import java.util.List;

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
        for (int i = 0; i < 3; i += 1) {
            if (input.charAt(i) < '1' || input.charAt(i) > '9') throw new IllegalArgumentException();
        }
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
