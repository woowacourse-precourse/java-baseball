package baseball.io;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserInput {

    private List<Integer> userInputNumbers;

    private static final String REGEX = "[1-9]+";
    private static final String INVALID_INPUT_MESSAGE = "잘못된 입력입니다.";

    public UserInput(String input) {
        checkIsValidInput(input);
        this.userInputNumbers = input.chars()
                .mapToObj(ch -> ch - '0')
                .collect(Collectors.toList());
    }

    private void checkIsValidInput(String input) {
        if (!input.matches(REGEX) || input.length() != 3) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }

        Set<Integer> inputSet = input.chars()
                .mapToObj(ch -> ch - '0')
                .collect(Collectors.toSet());
        if (inputSet.size() != 3) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }

    public List<Integer> getUserInputNumbers() {
        return userInputNumbers;
    }
}
