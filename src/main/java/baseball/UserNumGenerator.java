package baseball;

import java.util.ArrayList;
import java.util.List;

import static baseball.Constants.INPUT_LENGTH;


public class UserNumGenerator {
    public final List<Integer> NUMS;

    public UserNumGenerator(String input) {
        NUMS = generate(input);
    }

    public List<Integer> generate(String input) {
        List<Integer> nums = new ArrayList<>();
        if (!isValid(input)) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < INPUT_LENGTH; i++) {
            nums.add(Integer.parseInt(input.substring(i, i + 1)));
        }
        return nums;
    }

    public boolean isOneToNine(String input) {
        return input != null && input.matches("[1-9]+");
    }

    public boolean isNotDuplicate(String input) {
        List<Character> nums = new ArrayList<>();
        for (int i = 0; i < INPUT_LENGTH; i++) {
            if (!nums.contains(input.charAt(i))) {
                nums.add(input.charAt(i));
                continue;
            }
            return false;
        }
        return true;
    }

    public boolean isValid(String input) {
        return input.length() == 3 && isOneToNine(input) && isNotDuplicate(input);
    }
}
