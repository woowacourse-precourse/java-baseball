package baseball.game;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static baseball.game.Const.*;

public class User {
    private List<Integer> numbers;

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    public void setNumbers(String input) {
        validateInput(input);
        this.numbers = convertStringToNumbers(input);
    }

    private void validateInput(String input) {
        if (input.length() != GAME_LENGTH) {
            throw new IllegalArgumentException(GAME_EXCEPTION_LENGTH_MESSAGE);
        }
        if (!isOneToNine(input)) {
            throw new IllegalArgumentException(GAME_EXCEPTION_INTEGER_MESSAGE);
        }
    }

    private List<Integer> convertStringToNumbers(String input) {
        List<Integer> numbers = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .distinct()
                .collect(Collectors.toList());
        if (numbers.size() != GAME_LENGTH) {
            throw new IllegalArgumentException(GAME_EXCEPTION_DUPLICATE_MESSAGE);
        }
        return numbers;
    }
}
