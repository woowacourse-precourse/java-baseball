package baseball;

import static baseball.utils.Constants.RANDOM_NUMBER_LENGTH;
import static baseball.utils.ErrorMessages.BETWEEN_ONE_AND_NINE;
import static baseball.utils.ErrorMessages.REQUIRE_THREE_DIGIT_NUMBER;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private final List<Integer> numbers;

    private Player(int number) {
        validate(number);
        intToList(number);
        this.numbers = intToList(number);
    }

    public static Player from(int number) {
        return new Player(number);
    }

    private void validate(int number) {
        if (String.valueOf(number).length() != RANDOM_NUMBER_LENGTH) {
            throw new IllegalArgumentException(REQUIRE_THREE_DIGIT_NUMBER);
        }
        if (isNotBetweenOneAndNine(String.valueOf(number))) {
            throw new IllegalArgumentException(BETWEEN_ONE_AND_NINE);
        }
    }

    private boolean isNotBetweenOneAndNine(String string) {
        return string.contains("-") || string.contains("0");
    }

    private List<Integer> intToList(int number) {
        return Arrays.stream(String.valueOf(number).split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
