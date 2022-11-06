package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static baseball.Constants.INPUT_LENGTH;


public class UserNumGenerator {
    public final List<Integer> NUMS;

    public UserNumGenerator(String input) {
        NUMS = generate(input);
    }

    public List<Integer> generate(String input) {
        if (!isValid(input)) {
            throw new IllegalArgumentException();
        }
        return Arrays.asList(input.split("")).stream().map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }

    public boolean isOneToNine(String input) {
        return input != null && input.matches("[1-9]+");
    }

    public boolean isNotDuplicate(String input) {
        return Arrays.asList(input.split("")).stream().distinct().count() == INPUT_LENGTH;
    }

    public boolean isValid(String input) {
        return input.length() == INPUT_LENGTH && isOneToNine(input) && isNotDuplicate(input);
    }
}
