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
        for (int i = 0; i < input.length(); i += 1) {
            //indexOf 메서드는 입력값이 발견되는 즉시 return 한다. 즉, 2중 포문 역할을 한다.
            int duplicateIndex = input.indexOf(input.charAt(i));
            if (duplicateIndex != i) throw new IllegalArgumentException();
        }
    }
}
