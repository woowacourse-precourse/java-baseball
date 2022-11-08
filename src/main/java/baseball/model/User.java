package baseball.model;

import java.util.List;

import static baseball.model.Constants.INPUT_LENGTH;
import static baseball.model.Utils.*;


public class User {
    public final List<Integer> NUMS;

    public User(String input) {
        NUMS = generate(input);
    }

    public List<Integer> generate(String input) {
        if (!isValid(input)) {
            throw new IllegalArgumentException();
        }
        return stringToIntList(input);
    }

    public boolean isValid(String input) {
        return input.length() == INPUT_LENGTH && isOneToNine(input) && isNotDuplicate(input);
    }
}
