package baseball.io;

import java.util.List;
import java.util.stream.Collectors;

public class UserInput {

    private List<Integer> userInputNumbers;

    public UserInput(String input) {
        this.userInputNumbers = input.chars()
                .mapToObj(ch -> ch - '0')
                .collect(Collectors.toList());
    }

    public List<Integer> getUserInputNumbers() {
        return userInputNumbers;
    }
}
